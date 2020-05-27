package legalmanagement.rest;

import legalmanagement.data.Repository.AttorneyRepository;
import legalmanagement.data.entity.Attorney;
import legalmanagement.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


@Controller
public class MainController {

    @Autowired
    AttorneyRepository attorneyRepository;
    BCryptPasswordEncoder passwordEncoder;
    EmailService emailService;

    // Homepage Template
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView welcomePage(ModelAndView modelAndView) {
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    // Registration Template
    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registrationPage(ModelAndView modelAndView, Attorney user){
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    // Process input data form
    @RequestMapping(value= "/registration", method= RequestMethod.POST)
    public ModelAndView createUser(Attorney user, ModelAndView modelAndView, HttpServletRequest request){

        Attorney userExists = attorneyRepository.findByEmail(user.getEmail());

        if(userExists != null){
            modelAndView.addObject("There is already an Attorney registered with the email!");
            modelAndView.setViewName("error");

        } else {

            // This disables the attorney till the confirmation link is confirmed
            user.setEnabled(false);

            // This generates random 36-character string token for confirmation link
            user.setConfirmationToken(UUID.randomUUID().toString());

            attorneyRepository.save(user);

            String appUrl = request.getScheme() + "://" + request.getServerName();
            SimpleMailMessage registrationEmail = new SimpleMailMessage();
            registrationEmail.setTo(user.getEmail());
            registrationEmail.setSubject("Complete Registration");
            registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
                    + appUrl + "/confirm?token=" + user.getConfirmationToken());
            registrationEmail.setFrom("noreply@domain.com");

            emailService.sendEmail(registrationEmail);

            modelAndView.addObject("confirmationMessage",
                    "A verification e-mail has been sent to " + user.getEmail());

            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }

    // Processing link
    @RequestMapping(value="/confirm", method = RequestMethod.GET)
    public ModelAndView confirmUser(ModelAndView modelAndView, @RequestParam("token") String token) {

        Attorney user = attorneyRepository.findByConfirmationToken(token);

        if (user == null) {
            // No token found in DB
            modelAndView.addObject("invalidToken",
                    "Oops! This is an invalid confirmation link.");
        } else {
            // Token found
            modelAndView.addObject("confirmationToken", user.getConfirmationToken());
        }
        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    // Confirmation link
    @RequestMapping(value="/confirm", method = RequestMethod.POST)
    public ModelAndView processConfirmation(ModelAndView modelAndView) {

        modelAndView.setViewName("confirm");

        // Find the user associated with the reset token
        Attorney user = attorneyRepository.findByConfirmationToken(("token"));

        // Set new password
        user.setPassword(passwordEncoder.encode(("password")));

        // Set user to enabled
        user.setEnabled(true);

        // Save user
        attorneyRepository.save(user);

        modelAndView.addObject("successMessage",
                "Your email has been verified and your password has been saved!");
        return modelAndView;
    }

    //Login Template
    @RequestMapping(value= {"/login"}, method=RequestMethod.GET)
    public ModelAndView loginPage(ModelAndView modelAndView, Attorney user) {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("login");
        return modelAndView;
    }
}