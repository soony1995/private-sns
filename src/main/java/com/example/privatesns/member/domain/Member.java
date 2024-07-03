package com.example.privatesns.member.domain;

import com.example.privatesns.global.domain.BaseTimeEntity;
import com.example.privatesns.member.dto.SignUpRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;

//    @Column(nullable = false, unique = true, length = 50)
//    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(nullable = false)
    private String roles;

    @Column(length = 255)
    private String bio;

    public static Member fromSignUpRequest(String email, String password) {
        return Member.builder()
                .email(email)
                .password(password)
//                .username("defaultUsername")
                .roles("USER")
                .profilePicture(null)
                .bio(null)
                .build();
    }
}