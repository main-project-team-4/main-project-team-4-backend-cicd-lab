package com.example.demo.wish.controller;

import com.example.demo.security.UserDetailsImpl;
import com.example.demo.wish.service.WishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WishController {
    private final WishService wishService;

    @PostMapping("/api/items/{itemId}/wishes")
    public ResponseEntity<Void> toggleWish(
            @AuthenticationPrincipal UserDetailsImpl principal,
            @PathVariable Long itemId
    ) {
        return wishService.toggle(principal.getMember(), itemId);
    }
}