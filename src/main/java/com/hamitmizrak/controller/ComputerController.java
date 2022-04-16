package com.hamitmizrak.controller;

import com.hamitmizrak.data._1_ComputerEntity;
import com.hamitmizrak.repository._1_ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ComputerController {

    @Autowired
    _1_ComputerRepository  computerRepository;


    //Save
    // http://localhost:8080/computer/save
    @GetMapping("/computer/save")
    @ResponseBody
    public String saveComputer(){
        _1_ComputerEntity entity=_1_ComputerEntity
                .builder()
                    .computerId(0L)
                    .computerName("Bilgisayar Adı4554")
                    .computerTrade("Marka")
                    .computerPrice(7000)
                .build();

        computerRepository.save(entity);
        return "Ekleme Başarılı";
    }
}
