package com.books.book.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TokenBlacklisting {
    @Id
    private String token;
    private Instant blackListedAt;
    public TokenBlacklisting() {
    }
    public TokenBlacklisting(String token, Instant blackListedAt) {
        this.token = token;
        this.blackListedAt = blackListedAt;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public Instant getBlackListedAt() {
        return blackListedAt;
    }
    public void setBlackListedAt(Instant blackListedAt) {
        this.blackListedAt = blackListedAt;
    }

    
}
