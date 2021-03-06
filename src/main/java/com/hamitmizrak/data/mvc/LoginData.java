package com.hamitmizrak.data.mvc;

import com.hamitmizrak.data._1_ComputerEntity;
import com.hamitmizrak.data._2_ComputerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.util.Optional;

@Controller
@Log4j2
public class LoginData {
    //Revize yapılacak

//    @Autowired
//    LoginRepository loginRepository;
//
//
//    //Save
//    // http://localhost:8080/computer/save
//    // insert into computer (id,name) values (1L,"computer")
//    @GetMapping("/computer/save")
//    @ResponseBody
//    public String saveComputer(LoginDto loginDto) {
//        _1_ComputerEntity entity = _1_ComputerEntity
//                .builder()
//                .computerId(0L)
//                .computerName("Bilgisayar Adı4554")
//                .computerTrade("Marka")
//                .computerPrice(7000)
//                .build();
//        loginRepository.save(entity);//Kaydetmek
//        return "Ekleme Başarılı";
//    }
//
//    // save @RequestParam
//    // http://localhost:8080/computer/save/requestparam?computer_name=requestparamcomputer
//    @GetMapping("/computer/save/requestparam")
//    @ResponseBody
//    public String saveComputerRequestParam(@RequestParam(name = "computer_name") String computerName) {
//        _1_ComputerEntity entity = _1_ComputerEntity
//                .builder()
//                .computerId(0L)
//                .computerName(computerName)
//                .computerTrade("Marka")
//                .computerPrice(7000)
//                .build();
//        loginRepository.save(entity);//
//        return "Ekleme Başarılı";
//    }
//
//
//    // find
//    // http://localhost:8080/computer/find/1
//    // select * from computer where id=5;
//    @GetMapping("/computer/find/{id}")
//    @ResponseBody
//    public String findComputerById(@PathVariable(name = "id") Long idim) {
//        Optional<_1_ComputerEntity> optionalEntity = loginRepository.findById(idim);//bulmak
//
//        if (optionalEntity.isPresent()) {
//            _1_ComputerEntity entity = optionalEntity.get();
//            return "Bulundu: " + entity;
//        } else {
//            return idim + " id'li Aradığınız Data veri tabanında yoktur ";
//        }
//    }
//
//    // Delete
//    // http://localhost:8080/computer/delete/3
//    //delete from computer where id=4;
//    @GetMapping("/computer/delete/{id}")
//    @ResponseBody
//    public String deleteComputerId(@PathVariable(name = "id") Long idim) {
//        Optional<_1_ComputerEntity> optionalEntity = loginRepository.findById(idim);
//        if (optionalEntity.isPresent()) {
//            _1_ComputerEntity entity = optionalEntity.get();
//            loginRepository.deleteById(idim);//silmek
//            return "Silme Başarılı " + entity;
//        } else {
//            return idim + " id'li Aradığınız Data veri tabanında yoktur ";
//        }
//    }
//
//    //Update
//    //UPDATE computer SET  `computer_name` = 'Bilgisayar Adı33' WHERE (`id` = '3');
//    // http://localhost:8080/computer/update/2
//    @GetMapping("/computer/update/{id}")
//    @ResponseBody
//    public String updateComputer(@PathVariable(name = "id") Long idim) {
//        System.setProperty("java.awt.headless", "false");
//        Optional<_1_ComputerEntity> optionalEntity = loginRepository.findById(idim);
//        String name, trade;
//        double price;
//        if (optionalEntity.isPresent()) {
//            _1_ComputerEntity entity = optionalEntity.get();
//            name = JOptionPane.showInputDialog("Bilgisayar adını giriniz");
//            trade = JOptionPane.showInputDialog("Bilgisayar markasını giriniz");
//            price = Double.valueOf(JOptionPane.showInputDialog("Bilgisayar fiyatını giriniz"));
//            entity.setComputerName(name);
//            entity.setComputerTrade(trade);
//            entity.setComputerPrice(price);
//            loginRepository.save(entity);
//            return " Güncelleme başarılı";
//        } else {
//            return idim + " id'li Aradığınız Data veri tabanında yoktur ";
//        }
//    }
//
//    //List
//    // http://localhost:8080/computer/list
//    //SELECT * FROM computer;
//    @GetMapping("/computer/list")
//    @ResponseBody
//    public String listComputer(){
//        Iterable<_1_ComputerEntity> listem=  loginRepository.findAll();
//        for(_1_ComputerEntity temp: listem){
//            log.info(temp);
//        }
//        return listem+"\n";
//    }
}


