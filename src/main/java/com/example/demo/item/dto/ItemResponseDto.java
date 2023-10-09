package com.example.demo.item.dto;

import com.example.demo.item.entity.Item;
import lombok.Getter;

import java.net.URL;

@Getter
public class ItemResponseDto {
    public Long id;
    private Long shopId;
    private URL image;
    private String name;
    private int price;
    private String comment;

    public ItemResponseDto(Item item) {
        this.id = item.getId();
        this.shopId = item.getShop().getId();
        this.image = item.getImage();
        this.name = item.getName();
        this.price = item.getPrice();
        this.comment = item.getComment();
    }
}
