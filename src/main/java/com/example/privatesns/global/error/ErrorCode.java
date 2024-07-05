package com.example.privatesns.global.error;

import lombok.Getter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    //COMMON
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST.value(), "C001", HttpStatus.BAD_REQUEST.getReasonPhrase()),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED.value(), "C002", HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase()),
    ENTITY_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), "C003", HttpStatus.BAD_REQUEST.getReasonPhrase()),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST.value(), "C005", HttpStatus.BAD_REQUEST.getReasonPhrase()),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "C004", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
    HANDLE_ACCESS_DENIED(HttpStatus.FORBIDDEN.value(), "C006", HttpStatus.FORBIDDEN.getReasonPhrase()),

    //MEMBER
    MEMBER_ALREADY_REGISTERED(HttpStatus.BAD_REQUEST.value(), "M0001", HttpStatus.BAD_REQUEST.getReasonPhrase()),
    MEMBER_NOT_EXIST(HttpStatus.NOT_FOUND.value(), "M0002", HttpStatus.NOT_ACCEPTABLE.getReasonPhrase()),
    MEMBER_INVALID_AUTH_KEY(HttpStatus.FORBIDDEN.value(), "M0003", HttpStatus.FORBIDDEN.getReasonPhrase());


    private final int httpStatus;
    private final String code;
    private final String msg;
    }