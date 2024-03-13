package com.example.privatesns.utils;

import com.example.privatesns.dto.ErrorResponse;
import com.example.privatesns.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
public class ResponseBuilder {
    public static <T> ResponseEntity<T> buildOkResponse(T data) {
        return ResponseEntity.ok().body(data);
    }

    public static ResponseEntity<com.example.privatesns.dto.ErrorResponse> buildErrResponse(CustomException e) {
        log.info("error log : {}", e.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
        return ResponseEntity.status(e.getErrorCode().getHttpStatus()).body(errorResponse);
    }
}
