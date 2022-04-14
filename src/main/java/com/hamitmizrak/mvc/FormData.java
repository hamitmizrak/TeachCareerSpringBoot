package com.hamitmizrak.mvc;

import com.hamitmizrak.dto.AdminDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class FormData {

    //http://localhost:8080/form
    //http://localhost:8080/form/1
    @GetMapping({"form"} )
    public String getAdminForm(Model model) {
        AdminDto adminDto = null;
            adminDto= AdminDto
                        .builder()
                            .adminId(0)
                            .adminName("admin adı giriniz")
                            .adminSurname("admin soyadı giriniz")
                        .build();
        model.addAttribute("form_key",adminDto);
        return "_11_form";
    }

    //http://localhost:8080/form
    @PostMapping({"form"} )
    public String postAdminForm(Model model, AdminDto adminDto, BindingResult bindingResult) {
        log.info(adminDto);
        model.addAttribute("form_key",adminDto);
        return "_11_form";
    }

}
