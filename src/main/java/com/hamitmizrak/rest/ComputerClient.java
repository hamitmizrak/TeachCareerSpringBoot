package com.hamitmizrak.rest;

import com.hamitmizrak.dto.ComputerDto;
import com.hamitmizrak.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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


///////////////////////////////
    //ResponseEntity Object
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


    //ResponseEntity List => Object
    //http://localhost:8080/client7
    @GetMapping("client7")
    @ResponseBody
    public List<ComputerDto>  client7() {
        String URL="http://localhost:8080/rest7";
        RestTemplate restTemplate=new RestTemplate();

        ResponseEntity<List<ComputerDto>> responseEntity=
                restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<ComputerDto>>() {
        });

        List<ComputerDto> listBody=responseEntity.getBody();
        for(ComputerDto temp:listBody){
            log.info(temp);
        }
        return listBody;
    }

}
