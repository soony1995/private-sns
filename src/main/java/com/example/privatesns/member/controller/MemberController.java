package com.example.privatesns.member.controller;

import com.example.privatesns.member.domain.Member;
import com.example.privatesns.member.dto.SignUpRequest;
import com.example.privatesns.member.service.MemberSignUpService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberSignUpService memberSignUpService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerMember(@RequestBody SignUpRequest member) {
        Member registeredMember = memberSignUpService.registerMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredMember);
    }

    @GetMapping("/get")
    public String getSession(HttpSession session) {
        return (String) session.getAttribute("email");
    }
}
