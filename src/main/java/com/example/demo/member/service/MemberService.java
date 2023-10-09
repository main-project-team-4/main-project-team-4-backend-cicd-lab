package com.example.demo.member.service;

import com.example.demo.dto.MessageResponseDto;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.dto.SignupRequestDto;
import com.example.demo.member.entity.Member;
import com.example.demo.security.UserRoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<MessageResponseDto> signup(SignupRequestDto request) {

        String email = request.getEmail();
        String password = passwordEncoder.encode(request.getPassword());
        String nickname = request.getNickname();

        UserRoleEnum role = UserRoleEnum.USER;
        if(request.isRole()) {
            role = UserRoleEnum.ADMIN;
        }

        // email 중복 확인
        Optional<Member> checkEmail = memberRepository.findByUsername(email);
        if(checkEmail.isPresent()){
            throw new IllegalArgumentException("중복된 email 입니다.");
        }

        memberRepository.save(new Member(email, password, nickname, request.getPhoneNum()));

        MessageResponseDto msg = new MessageResponseDto("회원가입에 성공하였습니다.", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }
}
