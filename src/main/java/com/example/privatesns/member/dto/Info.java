package com.example.privatesns.member.dto;

import com.example.privatesns.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Info {

    @RequiredArgsConstructor
    @Builder
    @Getter
    public static class Response {
        final long memberId;
        final String email;
        final String username;
    }
}
