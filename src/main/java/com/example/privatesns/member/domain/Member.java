package com.example.privatesns.member.domain;

import com.example.privatesns.global.domain.BaseTimeEntity;
import com.example.privatesns.member.dto.Info;
import jakarta.persistence.*;
import lombok.*;

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

    private String username;

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

    public Info.Response convertToMemberInfoDto(){
        return Info.Response.builder()
                .memberId(this.id)
                .username(this.username)
                .email(this.email)
                .build();
    }
}