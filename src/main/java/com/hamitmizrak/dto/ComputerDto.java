package com.hamitmizrak.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

//lombok
@Data
@NoArgsConstructor
@Builder
@Log4j2

public class ComputerDto {
    private Long computerId;
    private String computerName;
    private double computerPrice;

    public ComputerDto(Long computerId, String computerName, double computerPrice) {
        this.computerId = computerId;
        this.computerName = computerName;
        this.computerPrice = computerPrice;
    }
}
