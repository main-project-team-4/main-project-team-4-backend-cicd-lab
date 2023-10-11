package com.example.demo.category.dto;

import com.example.demo.category.entity.CategoryL;
import com.example.demo.category.entity.CategoryM;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter @RequiredArgsConstructor
public class CategoryResponseDto {
    @Schema(description = "카테고리 id", example = "1")
    private Long id;
    @Schema(description = "카테고리 이름", example = "남성의류")
    private String name;

    public CategoryResponseDto(CategoryL entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public CategoryResponseDto(CategoryM entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
