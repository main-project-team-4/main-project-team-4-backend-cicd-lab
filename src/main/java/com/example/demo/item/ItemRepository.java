package com.example.demo.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i " +
            "JOIN FETCH i.categoryMidId " +
            "WHERE i.categoryMidId.parent.id = :id")
    List<Item> findByCategoryLargeId(Long id);

    @Query("SELECT i FROM Item i " +
            "JOIN FETCH i.categoryMidId " +
            "WHERE i.categoryMidId.id = :id")
    List<Item> findByCategoryMiddleId(Long id);
}
