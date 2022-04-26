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


@RestController
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
    //client Server'a HttpHeader ile veri gönderdi
    //http://localhost:8080/client/header
    @GetMapping("/client/header")
    @ResponseBody
    public String getClientHeader() {
        String URL = "http://localhost:8080/server/client/header";
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("client_key","Merhabalar ben gizli bilgiyim");
        HttpEntity<String> httpEntity=new HttpEntity<>("veri",httpHeaders);
        ResponseEntity<String> responseEntity=restTemplate.exchange(URL,HttpMethod.GET,httpEntity,String.class);
        String body=responseEntity.getBody();
        return body;
    }


    //Server client'a HttpHeader ile veri gönderdi
    //http://localhost:8080/client/header2
    @GetMapping("/client/header2")
    @ResponseBody
    public String getClientHeader2() {
        String URL = "http://localhost:8080/server/response/header";
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> responseEntity=restTemplate.exchange(URL,HttpMethod.GET,HttpEntity.EMPTY,String.class);
        String gelenData=responseEntity.getHeaders().getFirst("server_key");
        String body=responseEntity.getBody();
        return "@Controller"+body+" "+gelenData;
    }

    /////////////////////////////////////////////////////////////////////////////////////
//Browserda saklanır: browser cache belleğini silerseniz silinir.

    //client Server'a Cookie gönderdi
    // http://localhost:8080/rest/response/cookie
    @GetMapping("/rest/response/cookie")
    @ResponseBody
    public ResponseEntity<?> getCookie() {
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE,"key_response_cookie")
                .body("@RestController ==> ");
    }


    // http://localhost:8080/controller/response/cookie/header2
    @GetMapping("/controller/response/cookie/header2")
    @ResponseBody
    public String getCookieController2() {
        String URL = "http://localhost:8080/rest/response/cookie2";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, HttpEntity.EMPTY, String.class);
        String data=response.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
        String body = response.getBody();
        return "@Controller ==> " + body+" "+data;
    }

}
