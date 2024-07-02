package com.example.privatesns.global.exception;

import com.example.privatesns.global.dto.ErrorRes;
import com.example.privatesns.global.exception.CustomException;
import com.example.privatesns.global.type.ErrCode;
import com.example.privatesns.global.utils.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorRes> handleCustomException(CustomException e) {
        return ResponseBuilder.buildErrResponse(e);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorRes> handleException(Exception e) {
        log.error(e.getMessage());
        ErrorRes errorResponse = new ErrorRes(ErrCode.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(ErrCode.INTERNAL_SERVER_ERROR.getHttpStatus()).body(errorResponse);
    }
}