package com.example.demo.location.dto;

import com.fasterxml.jackson.databind.JsonNode;

public record CoordinateVo(
        Long Latitude,
        Long Longitude
) {
    // https://developers.kakao.com/tool/rest-api/open/get/v2-local-search-keyword.%7Bformat%7D
    public static CoordinateVo fromJsonNode(JsonNode jsonNode) {
        JsonNode documents = jsonNode.get("documents").get(0);
        return new CoordinateVo(
                documents.get("x").asLong(),
                documents.get("y").asLong()
        );
    }

    public static boolean hasCoordinate(JsonNode jsonNode) {
        return jsonNode.get("meta").get("total_count").asInt() > 0;
    }
}
