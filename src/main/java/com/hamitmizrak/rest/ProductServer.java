package com.hamitmizrak.rest;

//@GetMapping
//üreten:server
//tuketn:client

//@PostMapping


import com.hamitmizrak.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Log4j2
public class ProductServer {
    //SERVER
    //GET
    //http://localhost:8080/product/server
    @GetMapping("/product/server")
    public ProductDto getProductServer() {
        ProductDto productDto = ProductDto
                .builder()
                .productId(0L)
                .productName("ürün adı")
                .productTrade("ürün marka")
                .productPrice(1500)
                .build();
        // return "{ \"adı\":\"Hamit\" }";
        return productDto;
    }
    ////////////////////////////////////////////////////////////
//CLIENT


    //http://localhost:8080/product/server_client
    @PostMapping(value = "/product/server_client")
    public ProductDto postProduct(@RequestBody ProductDto productDto) {
        log.info(productDto);
        log.info("Serverdan geldi");
        return productDto;
    }

    //http://localhost:8080/product/server_client2
    @PutMapping(value = "/product/server_client2")
    public ProductDto putProduct(@RequestBody ProductDto productDto) {
        log.info(productDto);
        log.info("güncelleme tamam");
        return productDto;
    }

    //http://localhost:8080/product/server_client3/1
    @DeleteMapping(value = "/product/server_client3/{id}")
    public void deleteProduct(@PathVariable(name="id") Long id) {
        log.info(id+" silindir");
    }


    /////////////////////////////////////////////////////////////////////////////////////
    //client Server'a HttpHeader ile veri gönderdi
    //GET
    //http://localhost:8080/server/client/header
    @GetMapping("/server/client/header")
    public ResponseEntity<?> getHeader(@RequestHeader(value="client_key",defaultValue = "default bir değer") String data) {
        String headerData = "@RestController"+data;
        log.error(headerData);
        return ResponseEntity.ok(headerData);
    }



    //Server  Client'a HttpHeader ile veri gönderdi
    //GET
    //http://localhost:8080/server/response/header
    @GetMapping("/server/response/header")
    public ResponseEntity<?> getHeader2() {
        return ResponseEntity
                .ok()
                .header("server_key55","Serverdan gelen Gizli Bilgi")
                .body("@RestController geldi");
    }

    ///////////////////////////////////////////////////////////
    //COOKIE
    //client Server'a Cookie gönderdi
    //requestHeader: ben header içine bir data gönderiyorum
    // http://localhost:8080/rest/cookie
    @GetMapping("/rest/cookie")
    public ResponseEntity<?> getCookie(@CookieValue(value = "key_response_cookie66", defaultValue = "default cookie") String data) {
        String headerData = "@RestController geldiğinin kanıtı: " + data;
        System.out.println(headerData);
        return ResponseEntity.ok(headerData);
    }

///sERVER cLİENT
    // http://localhost:8080/rest/response/cookie2
    @GetMapping("/rest/response/cookie2")
    public ResponseEntity<?> getCookie2() {
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE,"key_response_cookie44")
                .body("@RestController ==> ");
    }



}
