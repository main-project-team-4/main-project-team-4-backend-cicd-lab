package com.example.demo.location.entity;

import com.example.demo.location.dto.LocationRequestDto;
import com.example.demo.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Entity
@Getter
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address_one;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Location(@RequestBody LocationRequestDto requestDto, Member member) {
        this.id = getId();
        this.state = requestDto.getState();
        this.city = requestDto.getCity();
        this.address_one = requestDto.getAddress_one();
    }

}
