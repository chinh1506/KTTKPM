package com.example.onthigk.service;

import com.example.onthigk.model.User;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {
    private final String JWT_SECRET = "chinh";
    private final long JWT_EXPIRATION = 604800000L;

    // Tao token tu user name
    public  String createToken(User user){
        Date date=new Date();
        Date expDate = new Date(date.getTime() + JWT_EXPIRATION);
        String token= Jwts.builder()
                .setSubject(user.getUserName())
                .setIssuedAt(date)
                .setExpiration(expDate)
                .signWith(SignatureAlgorithm.HS512,JWT_SECRET)
                .compact();
        return token;
    }
    public boolean vertifyToken(String token){
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException ex) {
            System.out.println("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            System.out.println("JWT claims string is empty.");
        }
        return false;
    }


}
