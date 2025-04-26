package com.books.book.service;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.books.book.dto.UserDto;
import com.books.book.jwt.JwtUtil;
import com.books.book.model.Role;
import com.books.book.model.TokenBlacklisting;
import com.books.book.model.User;
import com.books.book.repository.TokenBlacklistRepository;
import com.books.book.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenBlacklistRepository tokenBlacklistRepository;

    public void createUser(User user){
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
    
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    
        User newuser = new User();
        newuser.setUsername(user.getUsername());
        newuser.setPassword(passwordEncoder.encode(user.getPassword()));
        newuser.setRole(Role.USER);
        userRepository.save(newuser);
    }
    
    public String login(UserDto userDto){
        Optional<User> user = userRepository.findByUsername(userDto.getUsername());
        if (user.isPresent() && passwordEncoder.matches(userDto.getPassword(), user.get().getPassword())) {
            return jwtUtil.generateToken(user.get().getUsername(), user.get().getRole());
        }
        throw new RuntimeException("failed to generate token");
    }

    public void logout(String token){
        TokenBlacklisting tokenBlack = new TokenBlacklisting(token, Instant.now());
        tokenBlacklistRepository.save(tokenBlack);
    }
}
