package com.example.demo.follow.service;

import com.example.demo.follow.dto.FollowMemberResponseDto;
import com.example.demo.follow.entity.Follow;
import com.example.demo.follow.repository.FollowRepository;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.shop.entity.Shop;
import com.example.demo.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final MemberRepository memberRepository;
    private final FollowRepository followRepository;
    private final ShopRepository shopRepository;

    @Transactional
    public ResponseEntity<Void> doShopFollow(Member memberLoggedIn, Long shopId) {
        Shop shop = findShopById(shopId);

        Follow entity = new Follow(memberLoggedIn, shop);
        followRepository.save(entity);

        return ResponseEntity.ok(null);
    }

    private Shop findShopById(Long shopId) {
        return shopRepository.findById(shopId)
                .orElseThrow(() -> new IllegalArgumentException("해당 상점 ID는 존재하지 않습니다."));
    }

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

    public ResponseEntity<List<FollowMemberResponseDto>> readFollowersByShopId(Long shopId, Long id) {
        List<FollowMemberResponseDto> dtoList = memberRepository.findFollowersByMember_Id(shopId).stream()
                .map(FollowMemberResponseDto::new)
                .toList();
        return ResponseEntity.ok(dtoList);
    }
}
