package com.example.demo.wish.dto;

import com.example.demo.item.entity.Item;
import com.example.demo.wish.entity.Wish;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter @AllArgsConstructor
public class WishListResponseDto {
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("item_name")
    private String itemName;
    @JsonProperty("state")
    private String state;
    @JsonProperty("comment")
    private String comment;

    public WishListResponseDto(Wish entity) {
        Optional<Item> optionalItem = Optional.of(entity).map(Wish::getItem);

        this.imageUrl = optionalItem
                .map(Item::getMain_image)
                .map(Object::toString)
                .orElse(null);
        this.itemName = optionalItem
                .map(Item::getName)
                .orElse(null);
        this.state = optionalItem
                .map(Item::getState)
                .map(Enum::name)
                .orElse(null);
        this.comment = optionalItem
                .map(Item::getComment)
                .orElse(null);
    }
}
