package com.example.demo.shop.service;

import com.example.demo.dto.MessageResponseDto;
import com.example.demo.member.dto.SignupRequestDto;
import com.example.demo.member.entity.Member;
import com.example.demo.security.UserDetailsImpl;
import com.example.demo.shop.dto.ShopRequestDto;
import com.example.demo.shop.dto.ShopResponseDto;
import com.example.demo.shop.entity.Shop;
import com.example.demo.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

    public ResponseEntity<MessageResponseDto> createShop(SignupRequestDto requestDto, Member member) {
        Shop shop = new Shop(requestDto, member);
        shopRepository.save(shop);

        MessageResponseDto msg = new MessageResponseDto("상점이 생성되었습니다.", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    @Transactional
    public ResponseEntity<MessageResponseDto> updateShop(Long id, ShopRequestDto requestDto) {
        Shop shop = findShop(id);
        shop.update(requestDto);

        MessageResponseDto msg = new MessageResponseDto("상점 정보가 수정되었습니다.", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    public ResponseEntity<MessageResponseDto> deleteShop(Long id) {
        Shop shop = findShop(id);
        shopRepository.delete(shop);

        MessageResponseDto msg = new MessageResponseDto("상점이 삭제 되었습니다.", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    private Shop findShop(Long id) {
        return shopRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당하는 상점이 존재하지 않습니다.")
        );
    }

    public ShopResponseDto insertShop(Member member) {
        Shop shop = findShop(member.getId());
        return new ShopResponseDto(shop);
    }
}
