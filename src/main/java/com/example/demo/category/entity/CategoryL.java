package com.example.demo.category.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "category_large")
@Getter @Setter @NoArgsConstructor
public class CategoryL {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "parent")
    private List<CategoryM> categoryMiddles = new ArrayList<>();
}
