package com.example.demo.category.service;

import com.example.demo.category.repository.CategoryLRepository;
import com.example.demo.category.repository.CategoryMRepository;
import com.example.demo.category.type.CategoryType;
import com.example.demo.category.dto.CategoryRequestDto;
import com.example.demo.category.dto.CategoryResponseDto;
import com.example.demo.category.dto.ItemInCategoryResponseDto;
import com.example.demo.category.entity.CategoryL;
import com.example.demo.category.entity.CategoryM;
import com.example.demo.dto.MessageResponseDto;
import com.example.demo.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryLRepository categoryLRepository;
    private final CategoryMRepository categoryMRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public ResponseEntity<MessageResponseDto> createLarge(
            CategoryRequestDto request
    ) {
        CategoryL entity = new CategoryL(request.getName());
        categoryLRepository.save(entity);

        MessageResponseDto response = new MessageResponseDto("대분류 카테고리 생성 성공", HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @Transactional
    public ResponseEntity<MessageResponseDto> createChild(
            Long categoryId, CategoryRequestDto request
    ) {
        CategoryL categoryLargeEntity = findCategoryLargeById(categoryId);

        CategoryM entity = new CategoryM(request.getName(), categoryLargeEntity);
        categoryMRepository.save(entity);

        MessageResponseDto response = new MessageResponseDto("중분류 카테고리 생성 성공", HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @Transactional
    public ResponseEntity<MessageResponseDto> update(
            Long categoryId, int layer, CategoryRequestDto request
    ) {
        CategoryType categoryType = getTypeByLayer(layer);

        String msg = null;
        if (categoryType == CategoryType.LARGE) {
            CategoryL entity = findCategoryLargeById(categoryId);
            entity.update(request);

            msg = "대분류 카테고리 수정 성공";

        } else if (categoryType == CategoryType.MIDDLE) {
            CategoryM entity = findCategoryMiddleById(categoryId);
            entity.update(request);

            msg = "중분류 카테고리 수정 성공";

        }

        MessageResponseDto response = new MessageResponseDto(msg, HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @Transactional
    public ResponseEntity<MessageResponseDto> delete(
            Long categoryId, int layer
    ) {
        CategoryType categoryType = getTypeByLayer(layer);

        String msg = null;
        if (categoryType == CategoryType.LARGE) {
            CategoryL entity = findCategoryLargeById(categoryId);
            categoryLRepository.delete(entity);

            msg = "대분류 카테고리 삭제 성공";

        } else if (categoryType == CategoryType.MIDDLE) {
            CategoryM entity = findCategoryMiddleById(categoryId);
            categoryMRepository.delete(entity);

            msg = "중분류 카테고리 삭제 성공";

        }

        MessageResponseDto response = new MessageResponseDto(msg, HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<List<CategoryResponseDto>> readChildCategory(
            Long categoryId
    ) {
        CategoryL entity = findCategoryLargeById(categoryId);
        List<CategoryResponseDto> dtoList = entity.getCategoryMiddles().stream()
                .map(CategoryResponseDto::new)
                .toList();
        return ResponseEntity.ok(dtoList);
    }

    public ResponseEntity<List<ItemInCategoryResponseDto>> readChildItem(
            Long categoryId, int layer
    ) {
        CategoryType categoryType = getTypeByLayer(layer);

        List<ItemInCategoryResponseDto> response = null;
        if (categoryType == CategoryType.LARGE) {
            response = itemRepository.findByCategoryLargeId(categoryId).stream()
                    .map(ItemInCategoryResponseDto::new)
                    .toList();

        } else if (categoryType == CategoryType.MIDDLE) {
            response = itemRepository.findByCategoryMiddleId(categoryId).stream()
                    .map(ItemInCategoryResponseDto::new)
                    .toList();

        }

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<CategoryResponseDto> readCategory(
            Long categoryId, int layer
    ) {
        CategoryType categoryType = getTypeByLayer(layer);

        CategoryResponseDto response = null;
        if (categoryType == CategoryType.LARGE) {
            CategoryL entity = findCategoryLargeById(categoryId);
            response = new CategoryResponseDto(entity);

        } else if (categoryType == CategoryType.MIDDLE) {
            CategoryM entity = findCategoryMiddleById(categoryId);
            response = new CategoryResponseDto(entity);

        }

        return ResponseEntity.ok(response);
    }

    private CategoryL findCategoryLargeById(Long Id) {
        return categoryLRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("해당 대분류 카테고리는 존재하지 않습니다."));
    }

    private CategoryM findCategoryMiddleById(Long Id) {
        return categoryMRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("해당 중분류 카테고리는 존재하지 않습니다."));
    }

    private CategoryType getTypeByLayer(int layer) {
        return CategoryType.getTypeByLayer(layer)
                .orElseThrow(() -> new IllegalArgumentException(layer + " 라는 Layer는 존재하지 않습니다."));
    }
}
