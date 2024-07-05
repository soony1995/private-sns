package com.example.privatesns.member.service;

import com.example.privatesns.global.error.ErrorResponse;
import com.example.privatesns.global.error.ErrorCode;
import com.example.privatesns.member.dao.MemberFindDao;
import com.example.privatesns.member.domain.Member;
import com.example.privatesns.member.dto.Register;
import com.example.privatesns.member.exception.EmailDuplicateException;
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
    public Register.Response registerMember(Register.Request req) {

        if (memberRepository.existsByEmail(req.getEmail())) {
            throw new EmailDuplicateException(req.getEmail());
        }

        // need to validate password

        String encryptedPassword = passwordEncoder.encode(req.getPassword());
        Member member = req.toEntity(encryptedPassword);
        memberRepository.save(member);

        return new Register.Response(member.getId(), member.getUsername(), member.getEmail());
    }
}
