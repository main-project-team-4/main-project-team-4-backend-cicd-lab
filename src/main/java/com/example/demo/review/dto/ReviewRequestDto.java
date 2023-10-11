package com.example.demo.review.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class ReviewRequestDto {
    @Schema(description = "리뷰를 작성할 상품의 id", example = "1")
    private Long shopId;
    @Schema(description = "리뷰 내용", example = "맛있어요!")
    @NotBlank(message = "리뷰 내용을 입력해 주세요.")
    private String comment;
    @Schema(description = "리뷰 평점", example = "5")
    private int rating;
}
