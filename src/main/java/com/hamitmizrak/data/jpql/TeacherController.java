package com.hamitmizrak.data.jpql;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

    @Controller
    @Log4j2
    public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    //http://localhost:8080/ownQueryInterface/list
    @GetMapping("ownQueryInterface/list")
    @ResponseBody
    public String getTeacherList(Model model){
        List<TeacherEntity> teacherEntityList = new ArrayList<>();
        for(int i = 1; i<=10 ; i++){
            teacherEntityList.add(TeacherEntity.builder().teacherId(0L).teacherName("Adi".concat(""+i)).teacherSurname("Soyadi".concat(""+i)).build());
        }
        teacherEntityList.add(TeacherEntity.builder().teacherId(0L).teacherName("Adi11").teacherSurname("balicak").build());
        teacherEntityList.add(TeacherEntity.builder().teacherId(0L).teacherName("Adi12").teacherSurname("balicak").build());
        //liste olarak eklemek saveAll
        teacherRepository.saveAll(teacherEntityList);
        return "Liste eklendi" + teacherEntityList;
    }

    //http://localhost:8080/ownQueryInterface/balicak
    @GetMapping("ownQueryInterface/{surname}")
    @ResponseBody
    public String getTeacherMethod(@PathVariable(name = "surname") String surname){
        Iterable<TeacherEntity>  iterableList=    teacherRepository.findTeacherEntitiesByTeacherSurname(surname);
        for( TeacherEntity temp : iterableList ){
            log.info(temp);
        }
        return iterableList+"\n";
    }
}
