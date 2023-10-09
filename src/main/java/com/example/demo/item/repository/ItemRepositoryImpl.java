package com.example.demo.item.repository;

import com.example.demo.category.type.CategoryType;
import com.example.demo.item.entity.Item;
import com.example.demo.util.QueryBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements SearchRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Item> searchBy(
            String keyword
    ) {
        String query = "SELECT i FROM Item i %s %s";
        String whereQuery = QueryBuilder.aggWhereQuery(
                keywordWhereQuery(keyword)
        );

        query = String.format(query, "", whereQuery);
        return em.createQuery(query, Item.class).getResultList();
    }

    public String keywordWhereQuery(String keyword) {
        if(!StringUtils.hasText(keyword)) return null;

        String keywordLowerCase = keyword.toLowerCase();
        String query = "LOWER(i.name) LIKE CONCAT('%', ':keyword', '%')";
        return query.replace(":keyword", keywordLowerCase);
    }
}
