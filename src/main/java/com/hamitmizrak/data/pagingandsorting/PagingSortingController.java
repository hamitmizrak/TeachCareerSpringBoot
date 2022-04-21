package com.hamitmizrak.data.pagingandsorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PagingSortingController {

    @Autowired
    IPagingSorting iPagingSorting;

    //http://localhost:8080/pagingandsorting/save
    @GetMapping("pagingandsorting/save")
    @ResponseBody
    public String getPagingAndSortingList(){
        List<PagingSortingEntity> pagingsortingList = new ArrayList<>();
        for(int i = 1; i<=100 ; i++){
            pagingsortingList.add(PagingSortingEntity.builder().pagingId(0L).pagingName("Adi".concat(""+i)).build());
        }
       //liste olarak eklemek saveAll
        iPagingSorting.saveAll(pagingsortingList);
        return "Liste eklendi" + pagingsortingList;
    }

    //all pages

}
