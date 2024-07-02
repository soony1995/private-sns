package com.example.privatesns.member.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SignUpRequest {
    public final String email;
    public final String password;
}
