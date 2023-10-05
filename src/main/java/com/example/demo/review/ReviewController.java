package com.example.demo.review;


import com.example.demo.dto.MessageResponseDto;
import com.example.demo.security.UserDetailsImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/reviews")
    public ResponseEntity<MessageResponseDto> createReview(@RequestBody @Valid ReviewRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return reviewService.createReview(requestDto, userDetails.getMember());
    }




    @PutMapping("/reviews/{review_id}")
    public ResponseEntity<MessageResponseDto> updateReview(@PathVariable Long review_id, @RequestBody ReviewRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return reviewService.updateReview(review_id, requestDto, userDetails.getMember());
    }

    @DeleteMapping("/reviews/{review_id}")
    public ResponseEntity<MessageResponseDto> deleteReview(@PathVariable Long review_id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return reviewService.deleteReview(review_id, userDetails.getMember());
    }



}
