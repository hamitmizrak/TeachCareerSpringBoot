package com.hamitmizrak.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class _06_OwnLoginController {

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

    //http://localhost:8080/login
    // http://localhost:8080/login?error
    //http://localhost:8080/register
    @GetMapping("/register")
    public String getRegister(@RequestParam(value = "error", required = false) String error, Model model) {
        //kullanıcıadı ve şifre hatalı girilirise
        if (error != null) {
            model.addAttribute("key_register", "Kullanıcı adı ve şifreniz yanlıştır 44 !!!");
        } else {
            model.addAttribute("key_register", "Lütfen bilgileri giriniz");
        }
        return "register";
    }

    @GetMapping("/logout")
    @ResponseBody
    public String getLogout(HttpServletRequest request, HttpServletResponse response, Model model) {
        //Sayfaya giriş yapmış user
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
            model.addAttribute("key_logout", "Çıkış başarılı");
        }else {   model.addAttribute("key_logout", "Çıkış başarısız !!!!");       }
        return "Çıkış Yapıldı";
    }



}
