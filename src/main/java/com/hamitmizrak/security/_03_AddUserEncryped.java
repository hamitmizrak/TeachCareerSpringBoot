package com.hamitmizrak.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class _03_AddUserEncryped extends WebSecurityConfigurerAdapter {

   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{

      //Encoder Decoder
      PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();

      authenticationManagerBuilder
              .inMemoryAuthentication()
              .withUser("hamitmizrak")
              .password( passwordEncoder.encode("root"))
              .roles("ADMIN");

   }
}
