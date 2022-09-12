package com.example.jwtextuan3.service;

import com.example.jwtextuan3.model.User;
import org.springframework.stereotype.Service;

@Service
public class AccessUserService {
//    public String generateAccessToken(User user) {
//
//        return Jwts.builder()
//                .setSubject(String.format("%s,%s", user.getId(), user.getEmail()))
//                .setIssuer("CodeJava")
//                .claim("roles", user.getRoles().toString())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
//                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
//                .compact();
//    }
}
