package com.example.privatesns.member.service;

import com.example.privatesns.global.exception.CustomException;
import com.example.privatesns.member.domain.Member;
import com.example.privatesns.member.dto.Info;
import com.example.privatesns.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import static com.example.privatesns.global.type.ErrCode.MEMBER_NOT_EXIST;

@Service
@RequiredArgsConstructor
public class MemberInfoService {
    public final MemberRepository memberRepository;
    public Info.Response getCurrentMemberInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        String email = authentication.getName();
        Member member = memberRepository.findByEmail(email).orElseThrow(
                () -> new CustomException(MEMBER_NOT_EXIST));
        return member.convertToMemberInfoDto();
    }
}
