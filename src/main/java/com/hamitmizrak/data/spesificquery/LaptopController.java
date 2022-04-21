package com.hamitmizrak.data.spesificquery;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.IterableConfigurationPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Log4j2
public class LaptopController {

//    @Autowired
//    private LaptopImpl laptopImpl;
//
//    @Autowired
//    private LaptopRepository laptopRepository;

    //save
    //http://localhost:8080/laptop/save
//    @GetMapping("laptop/save")
//    @ResponseBody
//    public String getLaptopSave(){
//        LaptopEntity laptopEntity=null;
//            laptopEntity=LaptopEntity
//                    .builder()
//                        .laptopId(0L)
//                        .laptopName("Adı ")
//                        .laptopPrice(1000)
//                    .build();
//           laptopRepository.save(laptopEntity);
//        return "Laptop Eklendi";
//    }

    //minPrice
    //http://localhost:8080/laptop/findMinPrice/3000
//    @GetMapping("laptop/findMinPrice/{price}")
//    @ResponseBody
//    public String getLaptopFindMinPrice(@PathVariable(name="price") double price){
//        Iterable<LaptopEntity> iterableList= laptopImpl.findLaptopEntitiesBylaptopPrice(price);
//        for(LaptopEntity temp :iterableList){
//            log.info(temp);
//        }
//        return iterableList+" ";
//    }

    //Ödev
//    List<LaptopEntity> findLaptopEntityByLaptopNameStartsWith(String laptopName);
//    List<LaptopEntity> findLaptopEntityByLaptopNameEndssWith(String laptopName);
//    List<LaptopEntity> findLaptopEntityByLaptopNameEquals(String laptopName);
//    List<LaptopEntity> findLaptopEntityByLaptopNameLike(String laptopName);
}
