package com.example.privatesns.auth.service;


import ch.qos.logback.core.spi.ErrorCodes;
import com.example.privatesns.auth.domain.CustomUserDetails;
import com.example.privatesns.global.error.ErrorCode;
import com.example.privatesns.global.error.ErrorResponse;
import com.example.privatesns.member.dao.MemberFindDao;
import com.example.privatesns.member.domain.Member;
import com.example.privatesns.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.example.privatesns.global.error.ErrorCode.MEMBER_NOT_EXIST;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberFindDao memberFindDao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Member member = memberFindDao.findByEmail(username);
        return new CustomUserDetails(member);
    }
}