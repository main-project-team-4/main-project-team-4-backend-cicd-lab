package com.example.demo.shop.controller;

import com.example.demo.dto.MessageResponseDto;
import com.example.demo.member.dto.SignupRequestDto;
import com.example.demo.member.entity.Member;
import com.example.demo.security.UserDetailsImpl;
import com.example.demo.shop.service.ShopService;
import com.example.demo.shop.dto.ShopRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shops")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @PostMapping("/create")
    public ResponseEntity<MessageResponseDto> createShop(@RequestBody SignupRequestDto requestDto, Member member){
        return shopService.createShop(requestDto, member);
    }

    @PutMapping("/{shopId}")
    public ResponseEntity<MessageResponseDto> updateShop(@PathVariable("shopId") Long shopId, @RequestBody ShopRequestDto requestDto){
        return shopService.updateShop(shopId, requestDto);
    }

    @DeleteMapping("/{shopId}")
    public ResponseEntity<MessageResponseDto> deleteShop(@PathVariable("shopId") Long shopId){
        return shopService.deleteShop(shopId);
    }
}
