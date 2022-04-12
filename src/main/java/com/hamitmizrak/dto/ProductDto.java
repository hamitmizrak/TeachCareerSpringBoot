package com.hamitmizrak.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

//lombok
@Data

@NoArgsConstructor
@Builder
@Log4j2
public class ProductDto {
    private long productId;
    private String productName;
    private double productPrice;
    private String productTrade;

    public ProductDto(long productId, String productName, double productPrice, String productTrade) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productTrade = productTrade;
    }
}
