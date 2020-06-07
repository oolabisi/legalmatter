/*
package legalmanagement.rest;

import legalmanagement.data.Repository.ClientRepository;
import legalmanagement.data.entity.Client;
import legalmanagement.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Optional;
import java.util.UUID;


@Controller
public class MainClient {

    @Autowired
    ClientRepository clientRepository;
    BCryptPasswordEncoder passwordEncoder;
    EmailService emailService;


// ================================== HOME Template ===========================================================

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView modelAndView) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

// ================================== REGISTRATION Template ===========================================================


    // for CLIENT
    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public ModelAndView registration(ModelAndView modelAndView, Client user) {
        // modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    // Process input data form
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView process(ModelAndView modelAndView, @Valid Client user, BindingResult result,
                                            HttpServletRequest request) {

        // Lookup user in database by e-mail
        Optional<Client> userExists = clientRepository.findByEmail(user.getEmail());

        System.out.println(userExists);

        if (userExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage",
                    "There is already a user registered with the email provided.");
            modelAndView.setViewName("registration");
            result.reject("email");
        }

        if (!result.hasErrors()) {
            // new user so we create user and send confirmation e-mail

            // Set new password
            user.setPassword(passwordEncoder.encode(("password")));

            // Set user to enabled
            user.setEnabled(true);

            // Save user
            clientRepository.save(user);

            // Generate random 36-character string token for confirmation link
            user.setVerificationToken(UUID.randomUUID().toString());

            */
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
        *//*

        }
        modelAndView.addObject("successMessage", "Your password has been set!");

        modelAndView.setViewName("/");

        return modelAndView;
    }
*/
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
*//*


    // ==================================== LOGIN Template ================================================================
    //  for CLIENT
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login(ModelAndView model, String logout) {
        // modelAndView.addObject("user", user);

       */
/* if (user == null)

            modelAndView.addObject("error", "Your username and password are invalid.");
*//*

        if (logout != null)
            model.addObject("msg", "You have been logged out successfully.");

        model.setViewName("login");

        return model;
    }
}
*/
