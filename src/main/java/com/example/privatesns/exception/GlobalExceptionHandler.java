package com.example.privatesns.exception;

import com.example.privatesns.dto.ErrorResponse;
import com.example.privatesns.type.ErrCode;
import com.example.privatesns.utils.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        return ResponseBuilder.buildErrResponse(e);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error(e.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(ErrCode.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(ErrCode.INTERNAL_SERVER_ERROR.getHttpStatus()).body(errorResponse);
    }
}