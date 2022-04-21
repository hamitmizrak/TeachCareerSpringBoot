package com.hamitmizrak.data.pagingandsorting;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
public class PagingSortingController {

    @Autowired
    IPagingSorting iPagingSorting;

    //http://localhost:8080/pagingandsorting/save
    @GetMapping("pagingandsorting/save")
    @ResponseBody
    public String getSavePagingAndSortingList(){
        List<PagingSortingEntity> pagingsortingList = new ArrayList<>();
        for(int i = 1; i<=100 ; i++){
            pagingsortingList.add(PagingSortingEntity.builder().pagingId(0L).pagingName("Adi".concat(""+i)).build());
        }
       //liste olarak eklemek saveAll
        iPagingSorting.saveAll(pagingsortingList);
        return "Liste eklendi" + pagingsortingList;
    }

    //all pages all data
    //http://localhost:8080/pagingandsorting/pagingall
    @GetMapping("pagingandsorting/pagingall")
    @ResponseBody
    public String getPaging(){
        //0 demek 1.sayfa demek
        //1.sayfada 5 eleman getirç
        Pageable pageable= PageRequest.of(0,5);
        Page<PagingSortingEntity> entities=iPagingSorting.findAll(pageable);

        for(PagingSortingEntity temp :entities){
            log.info(temp);
        }
        return entities+" ";
    }

    //http://localhost:8080/pagingandsorting/paging/1
    @GetMapping("pagingandsorting/paging/{paging}")
    @ResponseBody
    public String getPagingSpecial(@PathVariable(name = "paging") int paging){
        Pageable pageable= PageRequest.of(paging,5);
        Page<PagingSortingEntity> entities=iPagingSorting.findAll(pageable);
        for(PagingSortingEntity temp :entities){
            log.info(temp);
        }
        return entities+" ";
    }


}
