package com.UserRole.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//import org.springframework.security.config.annotation.web.configuration.EnableGlobalMethodSecurity;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;


import org.springframework.security.core.context.SecurityContextImpl;

import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;



import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;

import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import org.springframework.security.web.context.SecurityContextRepository;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import org.springframework.security.web.savedrequest.RequestCache;

import com.UserRole.Service.PermissionService;

    @Configuration

    @EnableWebSecurity

    @EnableGlobalMethodSecurity(prePostEnabled = true)

    public class SecurityConfig {
    	
    
    	 @Autowired
    	    private CustomPermissionEvaluator customPermissionEvaluator;

        @Bean

        public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

            http

                .authorizeRequests(authorizeRequests ->

                    authorizeRequests

                        .antMatchers("/admin/**").hasRole("ADMIN")

                        .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")

                        .anyRequest().authenticated()

                )

                .formLogin(formLogin ->
                formLogin
                .loginPage("/login") // Customize the login page URL
                .defaultSuccessUrl("/dashboard")); // Customize the default success URL after login
        

            return http.build();

        }
        
//        @Bean
////        public RequestCache requestCache() {
////            return new HttpSessionRequestCache();
////        }
////        @Bean
////        public SecurityContextRepository securityContextRepository() {
////            return new HttpSessionSecurityContextRepository();
////        }
//
// 
      @Bean

      public WebSecurityExpressionHandler webSecurityExpressionHandler() {

         DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();

          handler.setPermissionEvaluator(new CustomPermissionEvaluator()); // Implement your own permission evaluator

         return handler;

      }

    }

   