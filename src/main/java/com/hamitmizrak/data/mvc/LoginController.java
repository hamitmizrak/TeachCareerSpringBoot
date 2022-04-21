package com.hamitmizrak.data.mvc;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
@Log4j2
@Controller
public class LoginController {

    //GetMapping
    //http://localhost:8080/mvc/data
    @GetMapping("/mvc/data")
    public String getValidation(Model model){
        model.addAttribute("key_mvc_data",new LoginDto());
        return "_13_springmvc_springdata_validation";
    }

    //GetMapping
    @PostMapping("/mvc/data")
    public String postValidation(@Valid @ModelAttribute("key_mvc_data")LoginDto loginDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("Hata meydana geldi");
            return "_13_springmvc_springdata_validation";
        }
        //database kaydedilecek
        log.info(loginDto);
        return "success2";
    }

}
