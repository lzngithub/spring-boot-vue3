package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static final String SALT = "123456";
    public static String getJwtToken(Map<String, Object> claims){
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))
                .sign(Algorithm.HMAC256(SALT));
    }

    public static Map<String, Object> checkJwtToken(String token){
        return JWT.require(Algorithm.HMAC256(SALT))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
