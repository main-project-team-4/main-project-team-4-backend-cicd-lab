package com.example.demo.member.controller;

import com.example.demo.dto.MessageResponseDto;
import com.example.demo.member.dto.LoginRequestDto;
import com.example.demo.member.dto.MemberInfoRequestDto;
import com.example.demo.member.dto.SignupRequestDto;
import com.example.demo.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class MemberController implements MemberDocs{
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<MessageResponseDto> signup(@Valid @RequestBody SignupRequestDto request) {
        return memberService.signup(request);
    }

    @PutMapping("/members/me")
    public ResponseEntity<MessageResponseDto> updateMember(@Valid @RequestBody MemberInfoRequestDto request, @RequestHeader("Authorization") String token) {
        return memberService.updateMember(request, token);//token을 받아서 수정
    }

    @DeleteMapping("/members/me")
    public ResponseEntity<MessageResponseDto> deleteMember(@Valid @RequestBody LoginRequestDto request, @RequestHeader("Authorization") String token) {
        return memberService.deleteMember(request, token);//token을 받아서 삭제
    }




}
