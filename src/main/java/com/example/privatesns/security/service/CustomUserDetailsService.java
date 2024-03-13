package com.example.privatesns.security.service;

import com.example.privatesns.domain.Member;
import com.example.privatesns.exception.CustomException;
import com.example.privatesns.repository.MemberRepository;
import com.example.privatesns.security.model.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.example.privatesns.type.ErrCode.MEMBER_NOT_EXIST;

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