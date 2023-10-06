package com.example.demo.item;

import com.example.demo.utils.LoadTeatCaseCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
class ItemRepositoryImplTest {
    @Autowired
    private ItemRepositoryImpl itemRepository;

    @LoadTeatCaseCategory
    @Test
    @DisplayName("[정상 작동] searchBy 함수 - 전체 조회")
    void searchBy_loadAllItem() {
        // given
        String keyword = null;
        Long categoryId = null;
        Integer layer = null;

        // when
        List<Item> items = itemRepository.searchBy(keyword, categoryId, layer);

        // then
        int numExpected = 8;

        items.stream().map(Item::getComment).forEach(log::info);
        assertThat(items.size()).isEqualTo(numExpected);
    }

    @LoadTeatCaseCategory
    @Test
    @DisplayName("[정상 작동] searchBy 함수 - 키워드로 조회")
    void searchBy_loadWithKeyword() {
        // given
        String keyword = "ean";
        Long categoryId = null;
        Integer layer = null;

        // when
        List<Item> items = itemRepository.searchBy(keyword, categoryId, layer);

        // then
        int numExpected = 4;

        items.stream().map(Item::getComment).forEach(log::info);
        assertThat(items.size()).isEqualTo(numExpected);
        for (Item item : items) {
            assertThat(item.getName().contains(keyword)).isTrue();
        }
    }

    @LoadTeatCaseCategory
    @Test
    @DisplayName("[정상 작동] searchBy 함수 - 대분류 카테고리로 조회")
    void searchBy_loadWithCategoryLarge() {
        // given
        String keyword = null;
        Long categoryId = 1L;
        Integer layer = 1;

        // when
        List<Item> items = itemRepository.searchBy(keyword, categoryId, layer);

        // then
        int numExpected = 4;

        items.stream().map(Item::getComment).forEach(log::info);
        assertThat(items.size()).isEqualTo(numExpected);
        for (Item item : items) {
            assertThat(item.getComment().contains("man")).isTrue();
        }
    }

    @LoadTeatCaseCategory
    @Test
    @DisplayName("[정상 작동] searchBy 함수 - 중분류 카테고리로 조회")
    void searchBy_loadWithCategoryMiddle() {
        // given
        String keyword = null;
        Long categoryId = 1L;
        Integer layer = 2;

        // when
        List<Item> items = itemRepository.searchBy(keyword, categoryId, layer);

        // then
        int numExpected = 2;

        items.stream().map(Item::getComment).forEach(log::info);
        assertThat(items.size()).isEqualTo(numExpected);
        for (Item item : items) {
            assertThat(item.getComment().contains("man shirt")).isTrue();
        }
    }

    @LoadTeatCaseCategory
    @Test
    @DisplayName("[정상 작동] searchBy 함수 - 키워드 + 카테고리로 조회")
    void searchBy_loadWithKeywordAndCategory() {
        // given
        String keyword = "ack";
        Long categoryId = 1L;
        Integer layer = 1;

        // when
        List<Item> items = itemRepository.searchBy(keyword, categoryId, layer);

        // then
        int numExpected = 2;

        items.stream().map(Item::getComment).forEach(log::info);
        assertThat(items.size()).isEqualTo(numExpected);
        for (Item item : items) {
            assertThat(item.getComment().contains("man shirt")).isTrue();
        }
    }
}