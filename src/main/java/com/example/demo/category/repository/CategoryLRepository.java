package com.example.demo.category.repository;

import com.example.demo.category.entity.CategoryL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryLRepository extends JpaRepository<CategoryL,Long> {
    @Query("SELECT cl FROM CategoryL cl JOIN FETCH cl.categoryMiddles")
    List<CategoryL> findAllRecursively();
}
