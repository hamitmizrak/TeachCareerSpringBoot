package com.hamitmizrak.mvc;

import com.hamitmizrak.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerTutorials {

    //Root
    //http://localhost:8080/
    @GetMapping("/")
    @ResponseBody
    public String getRoot() {
        return "Root Bileşeni";
    }


    //th:text
    // http://localhost:8080/templates/thymeleaf1
    @GetMapping("templates/thymeleaf1")
    public String getThymleaf1() {
        return "_01_th_text";
    }

    //Model
    // http://localhost:8080/templates/thymeleaf2
    @GetMapping("templates/thymeleaf2")
    public String getThymleaf2Model(Model model) {
        model.addAttribute("key", "Model Merhabalar Nasılsınız");
        return "_02_model";
    }

    //messages.properties
    //css js
    // http://localhost:8080/templates/thymeleaf3
    @GetMapping("templates/thymeleaf3")
    public String getThymleaf3CssJs(Model model) {
        model.addAttribute("key", "Model Merhabalar Nasılsınız");
        return "_03_css_js";
    }

    //Object
    // http://localhost:8080/templates/thymeleaf4
    @GetMapping("templates/thymeleaf4")
    public String getThymleaf4Object(Model model) {
        model.addAttribute("key", "Model Merhabalar Nasılsınız");
        ProductDto productDto = ProductDto.builder()
                .productId(12L)
                .productName("BilgisayarXcd")
                .productPrice(250)
                .productTrade("Marka")
                .build();
        model.addAttribute("key2", productDto);
        return "_04_object";
    }


    //Object List
    // http://localhost:8080/templates/thymeleaf5
    @GetMapping("templates/thymeleaf5")
    public String getThymleaf5List(Model model) {
        List<ProductDto> productDtoList=new ArrayList<>();
        productDtoList.add(new ProductDto(1L,"Name1",2000,"marka1"));
        productDtoList.add(new ProductDto(2L,"Name2",3000,"marka2"));
        productDtoList.add(new ProductDto(3L,"Name3",4000,"marka3"));
        productDtoList.add(new ProductDto(4L,"Name4",5000,"marka4"));
        model.addAttribute("key_list",productDtoList);
        return "_05_object_list";
    }



}
