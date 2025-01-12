package com.example.demo.shop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ShopRequestDto {
    @Schema(description = "상점 이름", example = "고기닭고기")
    @NotBlank
    private String shopName;
    @Schema(description = "상점 소개", example = "가죽 자켓 팝니다")
    @NotBlank
    private String shopIntro;
}
