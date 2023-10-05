package com.example.demo.review;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class ReviewRequestDto {
    private String comment;
    private int rating;

}
