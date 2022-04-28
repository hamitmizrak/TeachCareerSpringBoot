package com.hamitmizrak.security;

import com.hamitmizrak.beans.PasswordBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class _05_Authentication{
//
//@EnableWebSecurity
//public class _05_Authentication extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                //dikkkattt: antMatchers ==> @GetMappingten gelen url yazılır.
//                .antMatchers("/", "/index", "/security/public", "/security/success")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }
//
//    @Autowired
//    PasswordBean passwordBean;
//
//    @Autowired
//    public void configureGlobalAddUser(AuthenticationManagerBuilder managerBuilder) throws Exception {
//        managerBuilder
//                .inMemoryAuthentication()
//                .withUser("hamitmizrak")
//                .password(passwordBean.passwordEncoder().encode("root"))
//                .roles("USER");
//    }
}
