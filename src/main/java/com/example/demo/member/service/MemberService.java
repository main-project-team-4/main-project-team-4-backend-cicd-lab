package com.example.demo.member.service;

import com.example.demo.dto.MessageResponseDto;
import com.example.demo.location.entity.Location;
import com.example.demo.location.repository.LocationRepository;
import com.example.demo.member.dto.SignupRequestDto;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final LocationRepository locationRepository;
    private final ShopService shopService;

    @Transactional
    public ResponseEntity<MessageResponseDto> signup(SignupRequestDto request) {

        String username = request.getUsername();
        String password = passwordEncoder.encode(request.getPassword());
        String nickname = request.getNickname();
        String phoneNum = request.getPhoneNum();
        String location = request.getLocation();


        // username 중복 확인
        validateUniqueUsername(username);

        // phone 인증 과정
        validatePhoneNumber(phoneNum);

        // location 저장
        List<Location> locationList = loadOrSaveLocation(location);

        // DB 저장
        Member entity = new Member(username, password, nickname, phoneNum, locationList);
        memberRepository.save(entity);

        // 회원가입 하면서 상점 생성
        Member member = findMemberByUsername(username);
        shopService.createShop(request, member);

        MessageResponseDto msg = new MessageResponseDto("회원가입에 성공하였습니다.", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    private Member findMemberByUsername(String username){
        return memberRepository.findMemberByUsername(username);
    }

    private void validateUniqueUsername(String username) {
        Optional<Member> checkUsername = memberRepository.findByUsername(username);
        if(checkUsername.isPresent()){
            throw new IllegalArgumentException("중복된 Username 입니다.");
        }
    }

    private void validatePhoneNumber(String phoneNum) {
        // TODO 휴대폰 인증
    }

    private List<Location> loadOrSaveLocation(String location) {
        Location entity = locationRepository.findByName(location)
                .orElseGet(() -> saveLocation(location));
        return List.of(entity);
    }

    private Location saveLocation(String location) {
        Location entity = new Location(location);
        return locationRepository.save(entity);
    }

}
