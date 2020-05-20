//package legalmanagement.rest;
//
//import legalmanagement.data.Repository.AttorneyRepository;
//import legalmanagement.data.Repository.ConfirmationTokenRepository;
//import legalmanagement.data.entity.Attorney;
//import legalmanagement.data.entity.ConfirmationToken;
//import legalmanagement.service.EmailSenderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//public class EmailController {
//
//    @Autowired
//    private AttorneyRepository attorneyRepository;
//
//    @Autowired
//    private ConfirmationTokenRepository confirmationTokenRepository;
//
//    @Autowired
//    private EmailSenderService emailSenderService;
//
//    @RequestMapping(value="/register", method = RequestMethod.GET)
//    public ModelAndView displayRegistration(ModelAndView modelAndView, Attorney user)
//    {
//        modelAndView.addObject("user", user);
//        modelAndView.setViewName("register");
//        return modelAndView;
//    }
//
//    @RequestMapping(value="/register", method = RequestMethod.POST)
//    public ModelAndView registerUser(ModelAndView modelAndView, Attorney user)
//    {
//
//        Attorney existingUser = attorneyRepository.findByEmailIgnoreCase(user.getEmail());
//        if(existingUser != null)
//        {
//            modelAndView.addObject("message","This email already exists!");
//            modelAndView.setViewName("error");
//        }
//        else
//        {
//            attorneyRepository.save(user);
//
//            ConfirmationToken confirmationToken = new ConfirmationToken(user);
//
//            confirmationTokenRepository.save(confirmationToken);
//
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setTo(user.getEmail());
//            mailMessage.setSubject("Complete Registration!");
//            mailMessage.setFrom("chand312902@gmail.com");
//            mailMessage.setText("To confirm your account, please click here : "
//                    +"http://localhost:8082/confirm-account?token="+confirmationToken.getConfirmationToken());
//
//            emailSenderService.sendEmail(mailMessage);
//
//            modelAndView.addObject("emailId", user.getEmail());
//
//            modelAndView.setViewName("successfulRegistration");
//        }
//
//        return modelAndView;
//    }
//
//    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
//    {
//        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
//
//        if(token != null)
//        {
//            Attorney user = attorneyRepository.findByEmailIgnoreCase(token.getUser().getEmail());
////            user.setEnabled(true);
//            attorneyRepository.save(user);
//            modelAndView.setViewName("accountVerified");
//        }
//        else
//        {
//            modelAndView.addObject("message","The link is invalid or broken!");
//            modelAndView.setViewName("error");
//        }
//
//        return modelAndView;
//    }
//}
