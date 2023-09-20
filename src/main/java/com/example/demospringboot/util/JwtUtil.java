package com.example.demospringboot.util;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${secret-key}")
    private String secretKey;

    public String generateJwt() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", "123");
        payload.put("role", "student");

        return Jwts.builder()
                .setClaims(payload)
                .setExpiration(new Date(System.currentTimeMillis() + 300_000))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Map<String, Object> getPayloadJwt(String token) {
        Jwt parse = Jwts.parser().setSigningKey(secretKey).parse(token);
        return (Map<String, Object>) parse.getBody();
    }
}
