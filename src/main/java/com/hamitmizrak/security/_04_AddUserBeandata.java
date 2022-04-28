package com.hamitmizrak.security;

import com.hamitmizrak.beans.PasswordBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


public class _04_AddUserBeandata{

//@EnableWebSecurity
//public class _04_AddUserBeandata extends WebSecurityConfigurerAdapter {
//
//   @Autowired
//   PasswordBean passwordBean;
//
//   @Autowired
//   public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
//      authenticationManagerBuilder
//              .inMemoryAuthentication()
//              .withUser("hamitmizrak")
//              .password(passwordBean.passwordEncoder().encode("root"))
//              .roles("ADMIN");
//
//   }
}
