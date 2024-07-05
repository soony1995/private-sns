package com.example.privatesns.member.service;

import com.example.privatesns.member.dao.MemberFindDao;
import com.example.privatesns.member.domain.Member;
import com.example.privatesns.member.dto.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberInfoService {
    public final MemberFindDao memberFindDao;

    public Info.Response getCurrentMemberInfo(Authentication auth) {
        Member member = memberFindDao.findByEmail(auth.getName());

        return member.convertToMemberInfoDto();
    }
}
