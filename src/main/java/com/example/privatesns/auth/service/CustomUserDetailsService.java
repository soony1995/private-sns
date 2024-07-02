package com.example.privatesns.auth.service;


import com.example.privatesns.auth.domain.CustomUserDetails;
import com.example.privatesns.global.exception.CustomException;
import com.example.privatesns.member.domain.Member;
import com.example.privatesns.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.example.privatesns.global.type.ErrCode.MEMBER_NOT_EXIST;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username).orElseThrow(
                () -> new CustomException(MEMBER_NOT_EXIST));
        return new CustomUserDetails(member);
    }
}