package com.hamitmizrak.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerTutorials {


    //http://localhost:8080/
    @GetMapping("/")
    @ResponseBody
    public String getRoot(){
        return "Root Bileşeni";
    }


    // http://localhost:8080/templates/thymeleaf1
    @GetMapping("templates/thymeleaf1")
    public String getThymleaf1() {
        return "_01_thymeleaf";
    }

    // http://localhost:8080/templates/thymeleaf2
    @GetMapping("templates/thymeleaf2")
    public String getThymleaf2(Model model) {
        model.addAttribute("key","Model Merhabalar Nasılsınız");
        return "_02_thymeleaf";
    }

}
