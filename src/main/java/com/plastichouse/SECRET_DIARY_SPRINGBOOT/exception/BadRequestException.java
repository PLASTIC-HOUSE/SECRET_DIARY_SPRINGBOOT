package com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.handler.GlobalException;
import org.springframework.http.HttpStatus;

public class BadRequestException extends GlobalException {

    private BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);
    }

}
