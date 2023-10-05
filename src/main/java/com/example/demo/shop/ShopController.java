package com.example.demo.shop;

import com.example.demo.dto.MessageResponseDto;
import com.example.demo.security.UserDetailsImpl;
import com.example.demo.shop.dto.ShopRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @PostMapping("/shop/create")
    public ResponseEntity<MessageResponseDto> createShop(@RequestBody ShopRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return shopService.createShop(requestDto, userDetails);
    }

    @PutMapping("/shop/{shopId}")
    public ResponseEntity<MessageResponseDto> updateShop(@PathVariable("shopId") Long shopId, @RequestBody ShopRequestDto requestDto){
        return shopService.updateShop(shopId, requestDto);
    }

    @DeleteMapping("/shop/{shopId}")
    public ResponseEntity<MessageResponseDto> deleteShop(@PathVariable("shopId") Long shopId){
        return shopService.deleteShop(shopId);
    }
}
