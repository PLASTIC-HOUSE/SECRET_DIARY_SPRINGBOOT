package com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.handler.GlobalException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends GlobalException {

    public static final NotFoundException USER_NOT_FOUND = new NotFoundException("User not found");

    private NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }

}
