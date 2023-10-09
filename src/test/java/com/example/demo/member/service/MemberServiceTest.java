package com.example.demo.member.service;

import com.example.demo.location.entity.Location;
import com.example.demo.location.repository.LocationRepository;
import com.example.demo.member.dto.SignupRequestDto;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MemberServiceTest {
    private final MemberRepository memberRepository = mock(MemberRepository.class);
    private final PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
    private final LocationRepository locationRepository = mock(LocationRepository.class);

    private final MemberService memberService = new MemberService(memberRepository, passwordEncoder, locationRepository);

    @Test
    @DisplayName("[정상 작동] 회원 가입 - 이미 존재하는 location")
    void signupWhenExistLocation() {
        // given
        SignupRequestDto requestDto = new SignupRequestDto();

        when(passwordEncoder.encode(any()))
                .thenReturn("mock encoded password");
        when(locationRepository.findByName(any()))
                .thenReturn(Optional.of(new Location("mock location")));

        // when
        memberService.signup(requestDto);

        // then
        verify(memberRepository, times(1))
                .save(any());

    }

    @Test
    @DisplayName("[정상 작동] 회원 가입 - 존재하지 않는 location")
    void signupWhenNonExistLocation() {
        // given
        SignupRequestDto requestDto = new SignupRequestDto();

        when(passwordEncoder.encode(any()))
                .thenReturn("mock encoded password");
        when(locationRepository.findByName(any()))
                .thenReturn(Optional.empty());
        when(locationRepository.save(any()))
                .thenReturn(new Location("mock location"));

        // when
        memberService.signup(requestDto);

        // then
        verify(memberRepository, times(1))
                .save(any());

    }

    @Test
    @DisplayName("[비정상 작동] 회원 가입 - 이미 존재하는 username")
    void signupWhenExistUsername() {
        // given
        SignupRequestDto requestDto = new SignupRequestDto();

        when(passwordEncoder.encode(any()))
                .thenReturn("mock encoded password");
        when(memberRepository.findByUsername(any()))
                .thenReturn(Optional.of(new Member()));
        when(locationRepository.findByName(any()))
                .thenReturn(Optional.of(new Location("mock location")));

        // when
        Executable func = () -> memberService.signup(requestDto);

        // then
        assertThrows(IllegalArgumentException.class, func);

    }
}