package com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.handler.GlobalException;
import org.springframework.http.HttpStatus;

public class UnAuthorizedException extends GlobalException {

    public static final UnAuthorizedException INVALID_TOKEN = new UnAuthorizedException("Invalid token");

    public static final UnAuthorizedException EXPIRED_TOKEN = new UnAuthorizedException("Expired token");

    private UnAuthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED.value(), message);
    }

}
