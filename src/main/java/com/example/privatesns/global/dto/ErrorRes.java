package com.example.privatesns.global.dto;

import com.example.privatesns.global.type.ErrCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ErrorRes {
    private final HttpStatus status;
    private final ErrCode errorCode;
    private final String errorMessage;

    public ErrorRes(ErrCode errorCode) {
        this.status = errorCode.getHttpStatus();
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDescription();
    }
}