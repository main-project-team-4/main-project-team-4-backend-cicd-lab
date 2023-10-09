package com.example.demo.item.dto;

import com.example.demo.item.entity.Item;
import lombok.Getter;

import java.net.URL;
import java.util.List;

@Getter
public class ItemResponseDto {

    public Long id;

    private Long shopId;

    private String name;

    private int price;

    private String comment;

    private URL main_image;

    private List<URL> sub_images;

    public ItemResponseDto(Item item) {
        this.id = item.getId();
        this.shopId = item.getShop().getId();
        this.name = item.getName();
        this.price = item.getPrice();
        this.comment = item.getComment();
        this.main_image = item.getMain_image();
        this.sub_images = item.getSub_images();
    }
}
