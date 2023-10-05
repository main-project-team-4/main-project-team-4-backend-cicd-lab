package com.example.demo.review;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class ReviewRequestDto {

    private Long shopId;
    @NotBlank(message = "리뷰 내용을 입력해 주세요.")
    private String comment;
    private int rating;
}
