package com.hamitmizrak.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerTutorials {

    //Root
    //http://localhost:8080/
    @GetMapping("/")
    @ResponseBody
    public String getRoot(){
        return "Root Bileşeni";
    }


    //th:text
    // http://localhost:8080/templates/thymeleaf1
    @GetMapping("templates/thymeleaf1")
    public String getThymleaf1() {
        return "_01_th_text";
    }

    //Model
    // http://localhost:8080/templates/thymeleaf2
    @GetMapping("templates/thymeleaf2")
    public String getThymleaf2(Model model) {
        model.addAttribute("key","Model Merhabalar Nasılsınız");
        return "_02_model";
    }

    //messages.properties
    //css js
    // http://localhost:8080/templates/thymeleaf3
    @GetMapping("templates/thymeleaf3")
    public String getThymleaf3(Model model) {
        model.addAttribute("key","Model Merhabalar Nasılsınız");
        return "_03_css_js";
    }



}
