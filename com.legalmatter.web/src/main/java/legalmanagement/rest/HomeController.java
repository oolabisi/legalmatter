package legalmanagement.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

     @RequestMapping(value = "/legalmatter")
     public String index() {
        return "index";
     }
}
