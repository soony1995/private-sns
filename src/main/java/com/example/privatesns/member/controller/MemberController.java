package com.example.privatesns.member.controller;

import com.example.privatesns.member.dto.Info;
import com.example.privatesns.member.dto.Register;
import com.example.privatesns.member.service.MemberInfoService;
import com.example.privatesns.member.service.MemberSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberSignUpService memberSignUpService;
    private final MemberInfoService memberInfoService;

    @PostMapping("/register")
    public Register.Response registerMember(@RequestBody Register.Request member) {
        return memberSignUpService.registerMember(member);
    }

    @GetMapping("/info")
    public Info.Response getCurrentMemberInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        return memberInfoService.getCurrentMemberInfo(authentication);
    }
}
