package com.hamitmizrak.rest;

import com.hamitmizrak.dto.ComputerDto;
import com.hamitmizrak.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

//client:tüketir
//server:üretir

@Log4j2
@Controller //client
public class ComputerClient {


    //http://localhost:8080/client1
    @GetMapping("client1")
    @ResponseBody
    public String client1() {
      // String url= "https://api.github.com/users";
        String url= "http://localhost:8080/rest1";
        RestTemplate restTemplate=new RestTemplate();
        String jsonData=restTemplate.getForObject(url,String.class);
        return "client: "+jsonData;
    }


    //http://localhost:8080/client2
    @GetMapping("client2")
    @ResponseBody
    public ComputerDto client2() {
        String URL="http://localhost:8080/rest2";
        RestTemplate restTemplate=new RestTemplate();
        ComputerDto computerDto=restTemplate.getForObject(URL,ComputerDto.class);
        return computerDto;
    }



    //ResponseEntity
    //http://localhost:8080/client3
    @GetMapping("client3")
    @ResponseBody
    public ComputerDto client3() {
        String URL="http://localhost:8080/rest2";
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<ComputerDto> responseEntity=restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY,ComputerDto.class);
        ComputerDto computerBody=responseEntity.getBody();
        return computerBody;
    }


}
