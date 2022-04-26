package com.hamitmizrak.rest;

import com.hamitmizrak.dto.ProductDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


//@GetMapping
//üreten:server
//tuketn:client

//@PostMapping
//üreten:client
//tuketn:server


@Controller
public class ProductClient {
    //client: tüketti
    @GetMapping
    public ProductDto getProductServer() {
        String URL = "http://localhost:8080/product/server";
        RestTemplate restTemplate = new RestTemplate();

        //ProductDto productDto=restTemplate.getForObject(URL,ProductDto.class);
        //return productDto;

        ResponseEntity<ProductDto> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY, ProductDto.class);
        ProductDto productDto = responseEntity.getBody();
        return productDto;
    }

    ////////////////////////////////////////////////////////////
    //client: üretti
    //http://localhost:8080/client/post
    @GetMapping("/client/post")
    @ResponseBody
    public String getProduct() {
        ProductDto productDto1 = ProductDto.builder()
                .productId(0L)
                .productName("Akıllı sistem")
                .productTrade("Yusuf INC")
                .productPrice(15000)
                .build();
        String URL = "http://localhost:8080/product/server_client";
        RestTemplate restTemplate = new RestTemplate();
        //empati kuruyorum.
        ProductDto productDto2 = restTemplate.postForObject(URL, productDto1, ProductDto.class);
        return "Yusuf üretti: " + productDto2;

    }


    //http://localhost:8080/client/post
    @GetMapping("/client/post2")
    @ResponseBody
    public String getProduct2() {
        ProductDto productDto1 = ProductDto.builder()
                .productId(0L)
                .productName("Akıllı sistem")
                .productTrade("Yusuf INC")
                .productPrice(15000)
                .build();
        String URL = "http://localhost:8080/product/server_client";
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<ProductDto> httpEntity = new HttpEntity<ProductDto>(productDto1);
        ResponseEntity<ProductDto> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, httpEntity, ProductDto.class);
        ProductDto productDto2 = responseEntity.getBody();
        return "Yusuf üretti: " + productDto2;

    }


    //http://localhost:8080/client/put?product_name=Akıllı sistem2
    @GetMapping("/client/put")
    @ResponseBody
    public String getProduct3(@RequestParam(name = "product_name") String productName) {
        ProductDto productDto1 = ProductDto.builder()
                .productId(0L)
                .productName(productName)
                .productTrade("Yusuf INC")
                .productPrice(15000)
                .build();
//        Uzun yazım
//        String URL = "http://localhost:8080/product/server_client2";
//        RestTemplate restTemplate = new RestTemplate();
//        HttpEntity<ProductDto> httpEntity=new HttpEntity<ProductDto>(productDto1);
//        ResponseEntity<ProductDto> responseEntity=restTemplate.exchange(URL,HttpMethod.POST,httpEntity,ProductDto.class);
//        ProductDto productDto2=responseEntity.getBody();
//        return "Yusuf üretti: " + productDto2;

        //Kısa Yazım
        return "Yusuf üretti: " + new RestTemplate().exchange("http://localhost:8080/product/server_client2", HttpMethod.POST, new HttpEntity<ProductDto>(productDto1), ProductDto.class).getBody();
    }


    //http://localhost:8080/client/delete/1
    @GetMapping("/client/delete/{id}")
    @ResponseBody
    public String getProductDelete(@PathVariable(name = "id") Long id) {

        String URL = "http://localhost:8080/product/server_client3/" + id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(URL, HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);
        return "Silindi";
    }


    /////////////////////////////////////////////////////////////////////////////////////
//Client Header ile Servera veri göndersin

    //http://localhost:8080/client/header
    @GetMapping("/client/header")
    @ResponseBody
    public String getClientHeader() {
        String URL = "http://localhost:8080/server/header";
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("key_header","Merhabalar ben gizli bilgiyim");

        HttpEntity<String> httpEntity=new HttpEntity<>("veri",httpHeaders);
        ResponseEntity<String> responseEntity=restTemplate.exchange(URL,HttpMethod.GET,httpEntity,String.class);
        String body=responseEntity.getBody();
        return body;
    }

}
