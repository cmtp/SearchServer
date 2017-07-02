package com.project.SearchProject.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author ctola
 */
public class JwtUtil {
    public String generateToken(String username, String userId, String secretKey){
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("userName", username+"");
        claims.put("userId", userId+"");

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
}
