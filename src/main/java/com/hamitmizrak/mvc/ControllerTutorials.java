package com.hamitmizrak.mvc;

import org.springframework.stereotype.Controller;
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
}
