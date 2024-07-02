package com.example.privatesns.global.type;

import lombok.Getter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@RequiredArgsConstructor
public enum ErrCode {
    //MEMBER
    MEMBER_NOT_AUTHORIZATION(HttpStatus.UNAUTHORIZED, "권한이 없습니다."),
    MEMBER_ALREADY_REGISTERED(HttpStatus.BAD_REQUEST, "이미 등록된 아이디입니다!"),
    MEMBER_NOT_EXIST(HttpStatus.NOT_FOUND, "user not found"),
    MEMBER_INVALID_AUTH_KEY(HttpStatus.FORBIDDEN, "Forbidden"),

    //SERVER
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부에 문제가 생겼습니다.");


    private final HttpStatus httpStatus;
    private final String description;
}