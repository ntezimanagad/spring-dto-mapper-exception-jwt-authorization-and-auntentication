package com.books.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.book.dto.UserDto;
import com.books.book.model.User;
import com.books.book.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
public ResponseEntity<String> register(@RequestBody User user) {
    try {
        userService.createUser(user);
        return ResponseEntity.ok("User created successfully");
    } catch (RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDto userDto){
        
        return ResponseEntity.ok(userService.login(userDto));
    }
    
    @PostMapping(value = "/logout")
    public ResponseEntity<?> logout(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            header = header.substring(7);
            userService.logout(header);
        }
        return ResponseEntity.ok("Successfull loged out");
    }
}
