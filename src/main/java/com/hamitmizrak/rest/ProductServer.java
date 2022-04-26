package com.hamitmizrak.rest;

//@GetMapping
//üreten:server
//tuketn:client

//@PostMapping


import com.hamitmizrak.dto.ProductDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

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

}
