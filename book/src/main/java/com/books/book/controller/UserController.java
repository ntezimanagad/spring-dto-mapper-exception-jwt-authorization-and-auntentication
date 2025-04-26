package com.books.book.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    
    @GetMapping(value = "/hello")
    public String helloUser(){
        return "Hello User";
    }
    @GetMapping(value = "/info")
    public String getContextData(){
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        return "Hello" + username;
    }
}
