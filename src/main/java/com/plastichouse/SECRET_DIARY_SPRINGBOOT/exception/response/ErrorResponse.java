package com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.response;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private final int status;
    private final String message;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
    
}
