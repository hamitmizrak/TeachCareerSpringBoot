package com.hamitmizrak.beans;


import com.hamitmizrak.dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//BaCı

@Configuration
public class BeanConfig {

    @Bean
    public BeanDto beanDto(){
        return BeanDto.builder().id(44L).beanData("Bean data44").beanName("Bean Name44").build();
    }
}
