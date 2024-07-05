package com.example.privatesns.member.dao;

import com.example.privatesns.member.domain.Member;
import com.example.privatesns.member.exception.EmailNotFoundException;
import com.example.privatesns.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberFindDao {

    private final MemberRepository memberRepository;

    public Member findByEmail(final String email) {
        final Optional<Member> member = memberRepository.findByEmail(email);
        member.orElseThrow(() -> new EmailNotFoundException(email));
        return member.get();
    }
}
