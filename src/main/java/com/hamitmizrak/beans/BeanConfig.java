package com.hamitmizrak.beans;


import com.hamitmizrak.dto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
//BaCa Sil

@Configuration
public class BeanConfig {

    @Bean(initMethod = "initialBeanMethod",destroyMethod = "destroyBeanMethod")
//    @Scope("session")
//    @Scope("request")
//    @Scope("singleton")
    public BeanDto beanDto(){
        return BeanDto.builder().id(44L).beanData("Bean data44").beanName("Bean Name44").build();
    }
}
