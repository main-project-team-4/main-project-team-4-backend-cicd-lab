package com.example.demo.member;

import com.example.demo.security.UserRoleEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table
@Getter @Setter @NoArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    public Member(String email, String password, String nickname, UserRoleEnum role) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
    }
}
