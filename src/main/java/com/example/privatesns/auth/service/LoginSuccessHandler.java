package com.example.privatesns.auth.service;

import com.example.privatesns.member.repository.MemberRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final MemberRepository memberRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        // 세션 생성
        HttpSession session = request.getSession(true); // true를 넘겨주면, 세션이 존재하지 않을 경우 새 세션을 생성합니다.
        String email = extractUsername(authentication); // 인증 정보에서 사용자 이름(이메일) 추출
        String sessionId = request.getSession().getId();

        session.setAttribute("email", email);
        memberRepository.findByEmail(email)
                .ifPresent(memberRepository::saveAndFlush);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String jsonResponse = String.format("{\"sessionId\": \"%s\"}", sessionId);
        response.getWriter().write(jsonResponse);
    }

    private String extractUsername(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
