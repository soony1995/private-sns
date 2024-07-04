package com.example.privatesns.member.controller;

import com.example.privatesns.global.utils.ResponseBuilder;
import com.example.privatesns.member.domain.Member;
import com.example.privatesns.member.dto.Info;
import com.example.privatesns.member.dto.SignUp;
import com.example.privatesns.member.service.MemberInfoService;
import com.example.privatesns.member.service.MemberSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.privatesns.global.utils.ResponseBuilder.buildOkResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberSignUpService memberSignUpService;
    private final MemberInfoService memberInfoService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerMember(@RequestBody SignUp.Request member) {
        Member registeredMember = memberSignUpService.registerMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredMember);
    }

    @GetMapping("/info")
    public ResponseEntity<Info.Response> getCurrentMemberInfo() {
        return buildOkResponse(memberInfoService.getCurrentMemberInfo());
    }
}
