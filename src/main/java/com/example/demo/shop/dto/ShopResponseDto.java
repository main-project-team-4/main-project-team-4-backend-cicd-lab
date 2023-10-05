package com.example.demo.shop.dto;

import com.example.demo.shop.entity.Shop;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShopResponseDto {
    private Long id;
    private String shopName;
    private String shopIntro;

    public ShopResponseDto(Shop shop){
        this.id = shop.getId();
        this.shopName = shop.getShopName();
        this.shopIntro = shop.getShopIntro();
    }
}
