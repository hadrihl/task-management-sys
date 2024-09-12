package com.example.task_management_sys.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    public String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    // Generate JWT Token
    private String generateJwtToken(Authentication authentication){
        String username = authentication.getName();

        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date().getTime() + expiration)))
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();
    }

    // Get username from JWT Token
    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .getBody().getSubject();
    }

    // Validate JWT Token  
    public boolean validateJwtToken(String authToken) {
        
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;

        } catch (SignatureException e) {
            System.err.println("Invalid JWT signature: " + e.getMessage());
        
        } catch (MalformedJwtException e) {
            System.err.println("Invalid JWT token: " + e.getMessage());
            
        } catch (ExpiredJwtException e) {
            System.err.println("JWT token is expired: " + e.getMessage());
            
        } catch (UnsupportedJwtException e) {
            System.err.println("JWT token is unsupported: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.err.println("JWT claims string is empty: " + e.getMessage());
        }

        return false;
    }     
}
