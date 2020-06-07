package legalmanagement.rest;

import legalmanagement.data.Repository.AttorneyRepository;
import legalmanagement.data.Repository.ClientRepository;
import legalmanagement.data.entity.Attorney;
import legalmanagement.data.entity.Client;
import legalmanagement.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.UUID;


@Controller
public class MainController {

    @Autowired
    AttorneyRepository attorneyRepository;
    BCryptPasswordEncoder passwordEncoder;
    EmailService emailService;


// ================================== HOME Template ===========================================================

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public ModelAndView welcomePage(ModelAndView modelAndView) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

// ================================== REGISTRATION Template ===========================================================


    // for ATTORNEY
    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public ModelAndView registrationPage(ModelAndView modelAndView, Attorney user) {
       modelAndView.setViewName("registration");
        return modelAndView;
    }

    // Process input data form
    @RequestMapping(value = {"/registration"}, method = RequestMethod.POST)
    public ModelAndView processRegistration(ModelAndView modelAndView, @Valid Attorney user, BindingResult result,
                                                HttpServletRequest request) {

        // Lookup user in database by e-mail
        Attorney userExists = attorneyRepository.findByEmail(user.getEmail());

        System.out.println(userExists);

        if (userExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage",
                    "There is already a user registered with the email provided.");
            result.reject("email");
            modelAndView.setViewName("registration");
        }

        if (!result.hasErrors()) {
            // new user so we create user and send confirmation e-mail

            // Set new password
            user.setPassword(passwordEncoder.encode(("password")));

            // Set user to enabled
            user.setEnabled(true);

            // Save user
            attorneyRepository.save(user);

            // Generate random 36-character string token for confirmation link
            user.setVerificationToken(UUID.randomUUID().toString());

            /*String appUrl = request.getScheme() + "://" + request.getServerName();

            SimpleMailMessage registrationEmail = new SimpleMailMessage();
            registrationEmail.setTo(user.getEmail());
            registrationEmail.setSubject("Registration Confirmation");
            registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
                    + appUrl + "/confirm?token=" + user.getVerificationToken());
            registrationEmail.setFrom("oolabisiogundairo@gmail.com");  //noreply@domain

            emailService.sendEmail(registrationEmail);

            modelAndView.addObject("confirmationMessage",
                    "A confirmation e-mail has been sent to " + user.getEmail());
        */
        }
        modelAndView.addObject("successMessage", "Your password has been set!");

        modelAndView.setViewName("redirect:/welcome");

        return modelAndView;
    }
/*

    // Process confirmation link
    @RequestMapping(value="/confirm", method = RequestMethod.GET)
    public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam("token") String token) {

        Attorney user = attorneyRepository.findByVerificationToken(token);

        if (user == null) {
            // No token found in DB
            modelAndView.addObject("invalidToken",
                    "This is an invalid confirmation link.");
        } else {
            // Token found
            modelAndView.addObject("confirmationToken", user.getVerificationToken());
        }

        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    // Process confirmation link
    @RequestMapping(value="/confirm", method = RequestMethod.POST)
    public ModelAndView processConfirmation(ModelAndView modelAndView) {

        modelAndView.setViewName("confirm");

       // Find the user associated with the reset token
        Attorney user = attorneyRepository.findByVerificationToken("token");

        // Set new password
        user.setPassword(passwordEncoder.encode(("password")));

        // Set user to enabled
        user.setEnabled(true);

        // Save user
        attorneyRepository.save(user);

        modelAndView.addObject("successMessage", "Your password has been set!");
        return modelAndView;
    }
*/

// ==================================== LOGIN Template ================================================================
    //  for ATTORNEY

   /* @RequestMapping(value = {"/attorney"},method = RequestMethod.GET)
    public ModelAndView attorneyPage (ModelAndView modelAndView){
        return new ModelAndView("attorney_login");
    }*/

    @RequestMapping(value = {"/login_attorney"}, method = RequestMethod.GET)
    public ModelAndView loginPage(ModelAndView modelAndView, Attorney user, String logout) {
        //modelAndView.addObject("user", user);

        if (user == null)
            modelAndView.addObject("error", "Your username and password are invalid.");
        if (logout != null)
            modelAndView.addObject("msg", "You have been logged out successfully.");

        modelAndView.setViewName("login_attorney");

        return modelAndView;
    }


    // for CLIENT
    @RequestMapping(value = {"/client"},method = RequestMethod.GET)
    public ModelAndView clientPage (ModelAndView modelAndView){
        return new ModelAndView("client_login");
    }

    @RequestMapping(value = {"/login_client"}, method = RequestMethod.GET)
    public ModelAndView loginPage(ModelAndView modelAndView, Client user, String logout) {
        //modelAndView.addObject("user", user);

        if (user == null)
            modelAndView.addObject("error", "Your username and password are invalid.");
        if (logout != null)
            modelAndView.addObject("msg", "You have been logged out successfully.");

        modelAndView.setViewName("login_client");

        return modelAndView;
    }
}
