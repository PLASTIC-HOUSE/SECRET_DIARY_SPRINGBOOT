package com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.handler.GlobalException;
import org.springframework.http.HttpStatus;

public class ConflictException extends GlobalException {

    private ConflictException(String message) {
        super(HttpStatus.CONFLICT.value(), message);
    }

}
