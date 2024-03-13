package com.example.privatesns.exception;

import com.example.privatesns.type.ErrCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final ErrCode errorCode;
    private final String message;

    public CustomException(ErrCode errorCode) {
        this.message = errorCode.getDescription();
        this.errorCode = errorCode;
    }
}
