package com.example.demo.shop.dto;

import com.example.demo.shop.entity.Shop;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShopResponseDto {
    @Schema(description = "상점 id", example = "1")
    private Long id;
    @Schema(description = "상점 이름", example = "고기닭고기")
    private String shopName;
    @Schema(description = "상점 소개", example = "가죽 자켓 팝니다")
    private String shopIntro;

    public ShopResponseDto(Shop shop){
        this.id = shop.getId();
        this.shopName = shop.getMember().getNickname();
        this.shopIntro = shop.getShopIntro();
    }
}
