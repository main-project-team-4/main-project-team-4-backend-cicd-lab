package com.example.demo.category.dto;

import com.example.demo.category.entity.CategoryL;
import com.example.demo.category.entity.CategoryM;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class MidCategoryResponseDto {
    @JsonProperty("mid_category_id")
    private Long middleCategoryId;
    @JsonProperty("mid_category_name")
    private String middleCategoryName;
    @JsonProperty("large_category_id")
    private Long parentId;
    @JsonProperty("large_category_name")
    private String parentName;

    public MidCategoryResponseDto(CategoryL categoryL, CategoryM categoryM) {
        this.middleCategoryId = categoryM.getId();
        this.middleCategoryName = categoryM.getName();
        this.parentId = categoryL.getId();
        this.parentName = categoryL.getName();
    }
}
