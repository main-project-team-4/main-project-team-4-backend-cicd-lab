package com.example.demo.follow.controller;

import com.example.demo.follow.dto.FollowMemberResponseDto;
import com.example.demo.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FollowController {
    private final FollowService followService;

    @GetMapping("/api/members/{memberId}/followers")
    public ResponseEntity<List<FollowMemberResponseDto>> readFollowersByMemberId(
            @PathVariable Long memberId
    ) {
        return followService.readFollowersByMemberId(memberId);
    }

    @GetMapping("/api/members/{memberId}/followings")
    public ResponseEntity<List<FollowMemberResponseDto>> readFollowingsByMemberId(
            @PathVariable Long memberId
    ) {
        return followService.readFollowingsByMemberId(memberId);
    }
}
