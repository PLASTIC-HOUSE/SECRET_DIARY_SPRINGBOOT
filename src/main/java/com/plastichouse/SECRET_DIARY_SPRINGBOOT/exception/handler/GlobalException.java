package com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.handler;

import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException{

    private final int status;
    private final String message;

    protected GlobalException(Integer status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }
}
