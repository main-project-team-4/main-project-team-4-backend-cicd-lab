package com.example.demo.follow.service;

import com.example.demo.follow.dto.FollowMemberResponseDto;
import com.example.demo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final MemberRepository memberRepository;

    public ResponseEntity<List<FollowMemberResponseDto>> readFollowersByMemberId(Long memberId) {
        List<FollowMemberResponseDto> dtoList = memberRepository.findFollowersByMember_Id(memberId).stream()
                .map(FollowMemberResponseDto::new)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    public ResponseEntity<List<FollowMemberResponseDto>> readFollowingsByMemberId(Long memberId) {
        List<FollowMemberResponseDto> dtoList = memberRepository.findFollowingsByMember_Id(memberId).stream()
                .map(FollowMemberResponseDto::new)
                .toList();
        return ResponseEntity.ok(dtoList);
    }
}
