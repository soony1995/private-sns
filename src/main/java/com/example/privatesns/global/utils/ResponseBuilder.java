package com.example.privatesns.global.utils;

import com.example.privatesns.global.dto.ErrorRes;
import com.example.privatesns.global.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;

@Slf4j
public class ResponseBuilder {
    public static <T> ResponseEntity<T> buildOkResponse(T data) {
        return ResponseEntity.ok().body(data);
    }

    public static ResponseEntity<ErrorRes> buildErrResponse(CustomException e) {
        log.info("error log : {}", e.getMessage());
        ErrorRes errorResponse = new ErrorRes(e.getErrorCode());
        return ResponseEntity.status(e.getErrorCode().getHttpStatus()).body(errorResponse);
    }
}