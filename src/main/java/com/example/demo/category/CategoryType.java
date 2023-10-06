package com.example.demo.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@Getter @RequiredArgsConstructor
public enum CategoryType {
    LARGE(1, "대분류"),
    MIDDLE(2, "중분류");

    private final int layer;
    private final String description;

    public static Optional<CategoryType> getTypeByLayer(int layer) {
        return Arrays.stream(CategoryType.values())
                .filter(type -> type.layer == layer)
                .findFirst();
    }
}
