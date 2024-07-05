package com.example.privatesns.member.dto;

import com.example.privatesns.member.domain.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


public class Register {
    @RequiredArgsConstructor
    @Getter
    public static class Request {
        final String email;
        final String password;

        public Member toEntity(String password) {
            return Member.builder()
                    .email(this.getEmail())
                    .password(password)
                    .username("defaultUsername")
                    .roles("USER")
                    .profilePicture(null)
                    .bio(null)
                    .build();
        }
    }

    @RequiredArgsConstructor
    @Getter
    public static class Response {
        private final long userId;
        private final String username;
        private final String email;
    }
}

