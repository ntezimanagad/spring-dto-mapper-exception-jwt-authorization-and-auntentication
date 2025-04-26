package com.books.book.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.books.book.model.Role;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
    private static final String secretkey ="ZY9KssUP3Wx19ROeLGEoITsKaybEx20lK8JKWvYhgwA=";

    public String generateToken(String username, Role role){
        return Jwts.builder()
            .setSubject(username)
            .claim("role", role.name())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
            .signWith(SignatureAlgorithm.HS256, secretkey)
            .compact();
    }

    public String extractUsername(String token){
        return Jwts.parser()
            .setSigningKey(secretkey)
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    public Role extractRole(String token){
        String role = Jwts.parser()
            .setSigningKey(secretkey)
            .parseClaimsJws(token)
            .getBody()
            .get("role", String.class);
        return Role.valueOf(role);
    }

    public boolean validateToken(String username, String token){
        String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTOkenExpired(token));
    }

    public boolean isTOkenExpired(String token){
        Date expiration = Jwts.parser()
                .setSigningKey(secretkey)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}
