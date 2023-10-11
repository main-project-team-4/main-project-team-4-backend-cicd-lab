package com.example.demo.review.dto;


import com.example.demo.review.entity.Review;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class ReviewResponseDto {
    @Schema(description = "리뷰 id", example = "1")
    private Long id;
    @Schema(description = "리뷰 내용", example = "맛있어요!")
    private String comment;
    @Schema(description = "리뷰 작성 시간", example = "2021-08-09T15:00:00")
    private LocalDateTime createdAt;
    @Schema(description = "리뷰 수정 시간", example = "2021-08-09T15:00:00")
    private LocalDateTime modifiedAt;
    public ReviewResponseDto(Review review) {
        this.id = review.getId();
        this.comment = review.getComment();
        this.createdAt = review.getCreatedAt();
    }

}
