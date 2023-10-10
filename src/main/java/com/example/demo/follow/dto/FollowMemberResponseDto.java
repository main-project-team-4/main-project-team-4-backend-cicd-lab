package com.example.demo.follow.dto;

import com.example.demo.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter @AllArgsConstructor
public class FollowMemberResponseDto {
    private Long id;
    private String nickname;
    private String imageUrl;

    public FollowMemberResponseDto(Member entity) {
        this.id = entity.getId();
        this.nickname = entity.getNickname();
        this.imageUrl = Optional.of(entity)
                .map(Member::getImage)
                .map(Object::toString)
                .orElse(null);
    }
}
