package com.example.demo.member.entity;

import com.example.demo.location.entity.Location;
import com.example.demo.shop.entity.Shop;
import jakarta.persistence.*;
import lombok.*;

import java.net.URL;
import java.util.List;

@Entity @Table
@Getter @Setter @NoArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "phone_num")
    private String phoneNum;

    @OneToMany(mappedBy = "member")
    private List<Location> locations;

    @Column(name = "image")
    private URL image;

    @OneToOne(mappedBy = "member")
    private Shop shop;

    public Member(String username, String password, String nickname, String phoneNum) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.phoneNum = phoneNum;
    }

    public void updateMember(String username, String password, String nickname, String phoneNum, URL image) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.phoneNum = phoneNum;
        this.image = image;
    }
}
