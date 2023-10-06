package com.example.demo.item.query;

import com.example.demo.item.Item;

import java.util.List;

public interface SearchRepository {
    List<Item> searchBy(String keyword, Long category, Integer layer);
}
