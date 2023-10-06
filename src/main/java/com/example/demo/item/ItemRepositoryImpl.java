package com.example.demo.item;

import com.example.demo.category.CategoryType;
import com.example.demo.item.query.SearchRepository;
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
            String keyword, Long category, Integer layer
    ) {
        String query = "SELECT i FROM Item i %s %s";
        String joinQuery = categoryFetchQuery(category);
        String whereQuery = QueryBuilder.aggWhereQuery(
                keywordWhereQuery(keyword),
                categoryWhereQuery(category, layer)
        );

        query = String.format(query, joinQuery, whereQuery);
        return em.createQuery(query, Item.class).getResultList();
    }

    public String categoryFetchQuery(Long category) {
        return (category != null) ? "JOIN FETCH i.categoryMidId" : "";
    }

    public String keywordWhereQuery(String keyword) {
        if(!StringUtils.hasText(keyword)) return null;

        String keywordLowerCase = keyword.toLowerCase();
        String query = "LOWER(i.name) LIKE CONCAT('%', ':keyword', '%')";
        return query.replace(":keyword", keywordLowerCase);
    }

    public String categoryWhereQuery(Long category, Integer layer) {
        if (category == null) return null;
        return String.format(selectCategoryWhereQuery(layer), category);
    }

    public String selectCategoryWhereQuery(Integer layer) {
        CategoryType categoryType = CategoryType.getTypeByLayer(layer)
                .orElseThrow(() -> new IllegalArgumentException(layer + "라는 Layer값은 존재하지 않습니다."));
        return switch (categoryType) {
            case LARGE -> "i.categoryMidId.parent.id = %s";
            case MIDDLE -> "i.categoryMidId.id = %s";
        };
    }
}
