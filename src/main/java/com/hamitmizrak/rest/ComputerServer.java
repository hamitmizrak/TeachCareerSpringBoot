package com.hamitmizrak.rest;

import com.hamitmizrak.dto.ComputerDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//server:üreten
//client:tüketen

@Log4j2
@RestController //server
public class ComputerServer {

    //http://localhost:8080/rest1
    @GetMapping("rest1")
    public String rest1() {
        return "{\n" +
                "  \"name\":\"Hamit\",\n" +
                "  \"isLogin\":true,\n" +
                "  \"code\":44\n" +
                "}";
    }

    //http://localhost:8080/rest2
    @GetMapping("rest2")
    public ComputerDto rest2() {
        ComputerDto computerDto = ComputerDto
                .builder()
                .computerId(0L)
                .computerName("Bilgisayar adı")
                .computerPrice(454)
                .build();
        return computerDto;
    }

    //http://localhost:8080/rest3
    @GetMapping(value = "rest3", produces = MediaType.APPLICATION_JSON_VALUE)
    public ComputerDto rest3() {
        ComputerDto computerDto = ComputerDto
                .builder()
                .computerId(0L)
                .computerName("Bilgisayar adı")
                .computerPrice(454)
                .build();
        return computerDto;
    }

    //http://localhost:8080/rest4
    @GetMapping(value = "rest4", produces = MediaType.APPLICATION_XML_VALUE)
    public ComputerDto rest4() {
        ComputerDto computerDto = ComputerDto
                .builder()
                .computerId(0L)
                .computerName("Bilgisayar adı")
                .computerPrice(454)
                .build();
        return computerDto;
    }

    ////////////////////////////////////////////////////////////////////////////
    //PathVariable-1
    //http://localhost:8080/rest5/4
    @GetMapping(value = "rest5/{id}")
    public ComputerDto rest5(@PathVariable(name = "id") Long id) {
        ComputerDto computerDto = ComputerDto
                .builder()
                .computerId(id)
                .computerName("Bilgisayar adı")
                .computerPrice(454)
                .build();
        return computerDto;
    }

    //PathVariable-2
    //http://localhost:8080/rest6
    //http://localhost:8080/rest6/4
    @GetMapping({"rest6", "rest6/{id}"})
    public ComputerDto rest6(@PathVariable(name = "id", required = false) Long id) {
        ComputerDto computerDto = null;
        if (id == null) {
            log.error("Hata id null");

        } else {
            computerDto = ComputerDto
                    .builder()
                    .computerId(id)
                    .computerName("Bilgisayar adı")
                    .computerPrice(454)
                    .build();
        }
        return computerDto;
    }


    //http://localhost:8080/rest7
    @GetMapping(value = "rest7")
    public List<ComputerDto>  rest7() {
        List<ComputerDto> listem=new ArrayList<>();
        listem.add(ComputerDto.builder().computerId(1L).computerName("Bilgisayar adı1").computerPrice(100).build());
        listem.add(ComputerDto.builder().computerId(2L).computerName("Bilgisayar adı2").computerPrice(200).build());
        listem.add(ComputerDto.builder().computerId(3L).computerName("Bilgisayar adı3").computerPrice(300).build());
        listem.add(ComputerDto.builder().computerId(4L).computerName("Bilgisayar adı4").computerPrice(400).build());
        return listem;
    }

    //Json
/*    [
    {
        "computerId": 1,
            "computerName": "Bilgisayar adı1",
            "computerPrice": 100.0
    },
    {
        "computerId": 2,
            "computerName": "Bilgisayar adı2",
            "computerPrice": 200.0
    },
    {
        "computerId": 3,
            "computerName": "Bilgisayar adı3",
            "computerPrice": 300.0
    },
    {
        "computerId": 4,
            "computerName": "Bilgisayar adı4",
            "computerPrice": 400.0
    }
]*/

    /////////////////////////////////////////////////////////////////////////////////////
    //@PostMapping








    //@PutMapping
    //@DeleteMapping

}
