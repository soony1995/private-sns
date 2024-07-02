package com.example.privatesns.auth.service;

import com.example.privatesns.member.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final MemberRepository memberRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) {
        // 세션 생성
        HttpSession session = request.getSession(true); // true를 넘겨주면, 세션이 존재하지 않을 경우 새 세션을 생성합니다.
        String email = extractUsername(authentication); // 인증 정보에서 사용자 이름(이메일) 추출

        // 세션에 사용자 정보 저장
        session.setAttribute("email", email);

        // 사용자 정보를 데이터베이스에 저장 또는 업데이트
        memberRepository.findByEmail(email)
                .ifPresent(user -> {
                    // 추가적으로 필요한 로직 처리 (예: 사용자 로그인 시간 갱신 등)
                   memberRepository.saveAndFlush(user);
                });

        // 로그 정보
        log.info("로그인에 성공하였습니다. 이메일 : {}", email);
        log.info("세션 ID : {}", session.getId());
    }

    private String extractUsername(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
