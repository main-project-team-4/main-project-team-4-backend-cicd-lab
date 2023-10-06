package com.example.demo.category;

import com.example.demo.category.dto.CategoryRequestDto;
import com.example.demo.category.dto.CategoryResponseDto;
import com.example.demo.category.dto.ItemInCategoryResponseDto;
import com.example.demo.dto.MessageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/api/categories")
    public ResponseEntity<MessageResponseDto> createLarge(
            @RequestBody CategoryRequestDto request
    ) {
        return categoryService.createLarge(request);
    }

    @PostMapping("/api/categories/{categoryId}/categories")
    public ResponseEntity<MessageResponseDto> createMiddle(
            @PathVariable Long categoryId,
            @RequestBody CategoryRequestDto request
    ) {
        return categoryService.createChild(categoryId, request);
    }

    @GetMapping("/api/categories/{categoryId}")
    public ResponseEntity<CategoryResponseDto> read(
            @PathVariable Long categoryId,
            @RequestParam(defaultValue = "2") int layer
    ) {
        return categoryService.readCategory(categoryId, layer);
    }

    @GetMapping("/api/categories/{categoryId}/categories")
    public ResponseEntity<List<CategoryResponseDto>> readChildCategory(
            @PathVariable Long categoryId
    ) {
        return categoryService.readChildCategory(categoryId);
    }

    @GetMapping("/api/categories/{categoryId}/items")
    public ResponseEntity<List<ItemInCategoryResponseDto>> readChildItem(
            @PathVariable Long categoryId,
            @RequestParam(defaultValue = "2") int layer
    ) {
        return categoryService.readChildItem(categoryId, layer);
    }

    @PutMapping("/api/categories/{categoryId}")
    public ResponseEntity<MessageResponseDto> update(
            @PathVariable Long categoryId,
            @RequestParam(defaultValue = "2") int layer,
            @RequestBody CategoryRequestDto request
    ) {
        return categoryService.update(categoryId, layer, request);
    }

    @DeleteMapping("/api/categories/{categoryId}")
    public ResponseEntity<MessageResponseDto> delete(
            @PathVariable Long categoryId,
            @RequestParam(defaultValue = "2") int layer
    ) {
        return categoryService.delete(categoryId, layer);
    }
}
