package com.hamitmizrak.controller;

import com.hamitmizrak.data._1_ComputerEntity;
import com.hamitmizrak.repository._1_ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.util.Optional;

@Controller
public class ComputerController {

    @Autowired
    _1_ComputerRepository computerRepository;


    //Save
    // http://localhost:8080/computer/save
    // insert into computer (id,name) values (1L,"computer")
    @GetMapping("/computer/save")
    @ResponseBody
    public String saveComputer() {
        _1_ComputerEntity entity = _1_ComputerEntity
                .builder()
                .computerId(0L)
                .computerName("Bilgisayar Adı4554")
                .computerTrade("Marka")
                .computerPrice(7000)
                .build();
        computerRepository.save(entity);
        return "Ekleme Başarılı";
    }

    // save @RequestParam
    // http://localhost:8080/computer/save/requestparam?computer_name=requestparamcomputer
    @GetMapping("/computer/save/requestparam")
    @ResponseBody
    public String saveComputerRequestParam(@RequestParam(name = "computer_name") String computerName) {
        _1_ComputerEntity entity = _1_ComputerEntity
                .builder()
                .computerId(0L)
                .computerName(computerName)
                .computerTrade("Marka")
                .computerPrice(7000)
                .build();
        computerRepository.save(entity);
        return "Ekleme Başarılı";
    }


    // find
    // http://localhost:8080/computer/find/1
    // select * from computer where id=5;
    @GetMapping("/computer/find/{id}")
    @ResponseBody
    public String findComputerById(@PathVariable(name = "id") Long idim) {
        Optional<_1_ComputerEntity> optionalEntity = computerRepository.findById(idim);

        if (optionalEntity.isPresent()) {
            _1_ComputerEntity entity = optionalEntity.get();
            return "Bulundu: " + entity;
        } else {
            return idim + " id'li Aradığınız Data veri tabanında yoktur ";
        }
    }

    // Delete
    // http://localhost:8080/computer/delete/3
    //delete from computer where id=4;
    @GetMapping("/computer/delete/{id}")
    @ResponseBody
    public String deleteComputerId(@PathVariable(name = "id") Long idim) {
        Optional<_1_ComputerEntity> optionalEntity = computerRepository.findById(idim);
        if (optionalEntity.isPresent()) {
            _1_ComputerEntity entity = optionalEntity.get();
            computerRepository.deleteById(idim);
            return "Silme Başarılı " + entity;
        } else {
            return idim + " id'li Aradığınız Data veri tabanında yoktur ";
        }
    }

    //Update
    //UPDATE computer SET  `computer_name` = 'Bilgisayar Adı33' WHERE (`id` = '3');
    // http://localhost:8080/computer/update/3
    @GetMapping("/computer/update/{id}")
    @ResponseBody
    public String updateComputer(@PathVariable(name = "id") Long idim) {
        System.setProperty("java.awt.headless", "false");
        Optional<_1_ComputerEntity> optionalEntity = computerRepository.findById(idim);
        String name, trade;
        double price;
        if (optionalEntity.isPresent()) {
            _1_ComputerEntity entity = optionalEntity.get();
            name = JOptionPane.showInputDialog("Bilgisayar adını giriniz");
            trade = JOptionPane.showInputDialog("Bilgisayar markasını giriniz");
            price = Double.valueOf(JOptionPane.showInputDialog("Bilgisayar fiyatını giriniz"));
            entity.setComputerName(name);
            entity.setComputerTrade(trade);
            entity.setComputerPrice(price);
            computerRepository.save(entity);
            return " Güncelleme başarılı";
        } else {
            return idim + " id'li Aradığınız Data veri tabanında yoktur ";
        }
    }
}


