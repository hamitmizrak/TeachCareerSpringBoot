package com.hamitmizrak.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class _06_OwnLoginController {

    //http://localhost:8080/login
    // http://localhost:8080/login?error
    //http://localhost:8080/register
    @GetMapping("/register")
    public String getRegister(@RequestParam(value = "error", required = false) String error, Model model) {
        //kullanıcıadı ve şifre hatalı girilirise
        if (error != null) {
            model.addAttribute("key_register", "Kullanıcı adı ve şifreniz yanlıştır 44 !!!");
        }else{
            model.addAttribute("key_register", "Lütfen bilgileri giriniz");
        }
        return "register";
    }

    //PUBLIC
    //http://localhost:8080/security/public
    @GetMapping("/security/public")
    public String getPublic() {
        return "public";
    }


    //PRIVATE
    //http://localhost:8080/security/private
    @GetMapping("/security/private")
    public String getPrivate() {
        return "private";
    }
}
