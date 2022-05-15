package com.plastichouse.SECRET_DIARY_SPRINGBOOT.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenResponse {

    private final String accessToken;

}
