package com.example.demo.item.repository;

import com.example.demo.item.entity.Item;

import java.util.List;

public interface SearchRepository {
    List<Item> searchBy(String keyword);
}
