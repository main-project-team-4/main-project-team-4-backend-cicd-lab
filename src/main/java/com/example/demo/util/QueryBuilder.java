package com.example.demo.util;

import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

@UtilityClass
public class QueryBuilder {
    public String aggWhereQuery(String... wheres) {
        String prefix = "WHERE ";
        String delimiter = " AND ";
        String whereQueries = Arrays.stream(wheres)
                .filter(StringUtils::hasText)
                .collect(Collectors.joining(delimiter));
        return StringUtils.hasText(whereQueries) ? prefix + whereQueries : "";
    }

    public String reduceWithOr(String... wheres) {
        String delimiter = " OR ";
        return Arrays.stream(wheres)
                .filter(StringUtils::hasText)
                .collect(Collectors.joining(delimiter));
    }
}
