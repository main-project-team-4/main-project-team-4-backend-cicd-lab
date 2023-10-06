package com.example.demo.item;

import com.example.demo.category.entity.CategoryM;
import com.example.demo.member.Member;
import com.example.demo.shop.entity.Shop;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Optional;

@Getter @AllArgsConstructor
public class ItemSearchResponseDto {
    @JsonProperty("item_id")
    private Long itemId;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("category_name")
    private String categoryName;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_nickname")
    private String userNickname;

    @JsonProperty("item_name")
    private String itemName;

    @JsonProperty("price")
    private int price;

    @JsonProperty("image_url")
    private String imageUrl;

    public ItemSearchResponseDto(Item entity) {
        this.itemId = entity.getId();
        this.createdAt = entity.getCreatedAt();

        Optional<CategoryM> category = Optional.of(entity).map(Item::getCategoryMidId);
        this.categoryId = category.map(CategoryM::getId).orElse(null);
        this.categoryName = category.map(CategoryM::getName).orElse(null);

        Optional<Member> member = Optional.of(entity)
                .map(Item::getShop)
                .map(Shop::getMember);
        this.userId = member.map(Member::getId).orElse(null);
        this.userNickname = member.map(Member::getNickname).orElse(null);

        this.itemName = entity.getName();
        this.price = entity.getPrice();

        Optional<URL> imageUrl = Optional.of(entity).map(Item::getImage);
        this.imageUrl = imageUrl.map(URL::toString).orElse(null);
    }
}
