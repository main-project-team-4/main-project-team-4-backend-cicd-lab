package com.example.demo.category.dto;

import com.example.demo.category.entity.CategoryL;
import com.example.demo.category.entity.CategoryM;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter @RequiredArgsConstructor
public class CategoryResponseDto {
    private Long id;
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
