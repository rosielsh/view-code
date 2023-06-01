package com.example.UserServer.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Entity
@NoArgsConstructor
@Table(name="member")
public class Member {
    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String profileImg;
    private String username;
    private String nickname;
    private String role;

    @CreationTimestamp
    private Timestamp createDate;

    @Builder
    public Member(String email, String profileImg, String username, String nickname, String role, Timestamp createDate) {
        this.email = email;
        this.profileImg = profileImg;
        this.username = username;
        this.nickname = nickname;
        this.role = role;
        this.createDate = createDate;
    }
}