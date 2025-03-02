package com.thinkinnovative.demo_gradle.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JWTUtil {

    // Use a secure key of at least 256 bits
    private static final String SECRET = "your_secret_key_your_secret_key_your_secret_key"; // Must be at least 32 characters
    private static final Key SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());


    //String token = getTokenFromRequest(request);
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiry
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        // Using the correct method for parsing the JWT token
        JwtParser jwtParser = Jwts.parser().setSigningKey(SECRET_KEY).build();
        return jwtParser.parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        return  !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }



}


