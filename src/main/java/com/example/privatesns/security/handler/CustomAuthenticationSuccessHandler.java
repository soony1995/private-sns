package com.example.privatesns.security.handler;

import com.example.privatesns.security.component.JwtTokenProvider;
import com.example.privatesns.security.dto.TokenDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final JwtTokenProvider jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        TokenDto tokens = jwtService.generateToken(authentication);
        jwtService.addCookieToResponse(response, "accessToken", tokens.getAccessToken(), tokens.getExpiredTime());
        jwtService.addCookieToResponse(response, "refreshToken", tokens.getRefreshToken(), tokens.getExpiredTime());
    }
}
