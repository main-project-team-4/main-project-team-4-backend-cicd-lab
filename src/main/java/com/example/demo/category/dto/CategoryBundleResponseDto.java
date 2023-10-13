package com.example.demo.category.dto;

import com.example.demo.category.entity.CategoryL;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class CategoryBundleResponseDto {
    @JsonProperty("large_category_id")
    private Long largeCategoryId;
    @JsonProperty("large_category_name")
    private String largeCategoryName;
    @JsonProperty("children")
    private List<MidCategoryResponseDto> children;

    public CategoryBundleResponseDto(CategoryL categoryL) {
        this.largeCategoryId = categoryL.getId();
        this.largeCategoryName = categoryL.getName();
        this.children = categoryL.getCategoryMiddles().stream()
                .map(entity -> new MidCategoryResponseDto(categoryL, entity))
                .toList();
    }
}
