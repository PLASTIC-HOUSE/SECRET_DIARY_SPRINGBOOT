package com.plastichouse.SECRET_DIARY_SPRINGBOOT.security.jwt;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.property.JwtProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtProvider {

    private static final String PREFIX = "Bearer ";

    private final JwtProperties jwtProperties;

    //토큰 생성
    public TokenResponse generateToken(String nickname) {
        String accessToken = Jwts.builder()
                .setSubject(nickname)
                .setHeaderParam("typ", JwtProperties.ACCESS_TYPE)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getAccessExp()))
                .compact();

        return new TokenResponse(
                accessToken
        );
    }

    //Bearer 토큰 추출
    public String resolveToken(String token) {
        if (token != null
                && token.startsWith(PREFIX)
                && token.length() > PREFIX.length()) {
            return token.substring(PREFIX.length());
        }
        return null;
    }

}
