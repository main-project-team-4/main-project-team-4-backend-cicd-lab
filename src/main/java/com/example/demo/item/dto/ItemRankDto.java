package com.example.demo.item.dto;

import com.example.demo.item.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.URL;

@Getter
@NoArgsConstructor
public class ItemRankDto {
    private Long id;
    private URL image;
    private String name;
    private int price;

    public ItemRankDto(Item item) {
        this.id = item.getId();
        this.image = item.getMain_image();
        this.name = item.getName();
        this.price = item.getPrice();
    }
}
