package com.example.privatesns.member.service;

import com.example.privatesns.global.exception.CustomException;
import com.example.privatesns.global.type.ErrCode;
import com.example.privatesns.member.domain.Member;
import com.example.privatesns.member.dto.SignUp;
import com.example.privatesns.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberSignUpService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Member registerMember(SignUp.Request req) {
        if (memberRepository.existsByEmail(req.getEmail())) {
            throw new CustomException(ErrCode.MEMBER_ALREADY_REGISTERED);
        }
        String encryptedPassword = passwordEncoder.encode(req.getPassword());
        Member member = req.toEntity(encryptedPassword);
        return memberRepository.save(member);
    }
}
