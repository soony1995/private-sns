package com.example.privatesns.member.dto;

import com.example.privatesns.member.domain.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


public class SignUp {
    @RequiredArgsConstructor
    @Getter
    public static class Request {
        final String email;
        final String password;

        public  Member toEntity(String password) {
                return Member.builder()
                        .email(this.getEmail())
                        .password(password)
                        //                .username("defaultUsername")
                        .roles("USER")
                        .profilePicture(null)
                        .bio(null)
                        .build();
            }
    }


}
