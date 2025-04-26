package com.books.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.book.model.TokenBlacklisting;

public interface TokenBlacklistRepository extends JpaRepository<TokenBlacklisting, String>{
    boolean existsByToken(String token);
}
