package com.example.demo.location.entity;

import com.example.demo.location.dto.LocationRequestDto;
import com.example.demo.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Location(LocationRequestDto requestDto, Member member) {
        this.id = getId();
        this.name = requestDto.getName();
        this.member = member;
    }

    public Location(String location) {
        this.name = location;
    }

}
