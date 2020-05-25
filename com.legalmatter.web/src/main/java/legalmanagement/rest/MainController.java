package legalmanagement.rest;

import legalmanagement.data.Repository.AttorneyRepository;
import legalmanagement.data.entity.Attorney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class MainController {

    @Autowired
    AttorneyRepository attorneyRepository;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView welcomePage(ModelAndView modelAndView) {
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    // Return registration form template
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView registrationPage(ModelAndView modelAndView, Attorney user){
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value= {"/register"}, method= RequestMethod.POST)
    public ModelAndView createUser(@Valid Attorney user, BindingResult bindingResult , ModelAndView modelAndView){
        Attorney userExists = attorneyRepository.findByEmail(user.getEmail());
        if(userExists != null){
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
        }
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("attorney/register");
        } else {
            attorneyRepository.save(user);
            modelAndView.addObject("msg", "Name has been registered successfully!");
            modelAndView.addObject("user", new Attorney());
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }

    @RequestMapping(value= {"/login"}, method=RequestMethod.GET)
    public ModelAndView loginPage(ModelAndView modelAndView, Attorney user) {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("login");
        return modelAndView;
    }
}