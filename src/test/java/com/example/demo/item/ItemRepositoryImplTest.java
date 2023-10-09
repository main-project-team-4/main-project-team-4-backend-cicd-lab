package com.example.demo.item;

import com.example.demo.item.entity.Item;
import com.example.demo.item.repository.ItemRepositoryImpl;
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

        // when
        List<Item> items = itemRepository.searchBy(keyword);

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

        // when
        List<Item> items = itemRepository.searchBy(keyword);

        // then
        int numExpected = 4;

        items.stream().map(Item::getComment).forEach(log::info);
        assertThat(items.size()).isEqualTo(numExpected);
        for (Item item : items) {
            assertThat(item.getName().contains(keyword)).isTrue();
        }
    }
}