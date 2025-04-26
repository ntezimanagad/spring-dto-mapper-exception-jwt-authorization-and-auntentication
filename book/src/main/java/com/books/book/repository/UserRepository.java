package com.books.book.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.book.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
