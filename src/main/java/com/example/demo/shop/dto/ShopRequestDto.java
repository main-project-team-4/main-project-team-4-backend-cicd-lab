package com.example.demo.shop.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ShopRequestDto {
    @NotBlank
    private String shopName;
    @NotBlank
    private String shopIntro;
}
