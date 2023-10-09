package com.example.demo.category.dto;

import com.example.demo.item.entity.Item;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter @RequiredArgsConstructor
public class ItemInCategoryResponseDto {
    private Long id;
    private String name;
    private Integer price;
    private String imageUrl;

    public ItemInCategoryResponseDto(Item entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.imageUrl = null;
    }
}
