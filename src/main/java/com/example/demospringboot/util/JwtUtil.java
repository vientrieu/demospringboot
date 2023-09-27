package com.example.demospringboot.util;

import com.example.demospringboot.dto.UserAuthentication;
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
        UserAuthentication userAuthentication = new UserAuthentication();
        userAuthentication.setUserId(123L);
        userAuthentication.setRole("USER");
        Map<String, Object> payload = new HashMap<>();
        payload.put("user", userAuthentication);

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
