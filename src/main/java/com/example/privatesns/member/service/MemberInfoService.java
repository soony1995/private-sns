package com.example.privatesns.member.service;

import com.example.privatesns.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberInfoService {
    public String getCurrentUsername() {
           Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
           if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
               UserDetails userDetails = (UserDetails) authentication.getPrincipal();
               return userDetails.getUsername();
           }
           return null;
       }
}
