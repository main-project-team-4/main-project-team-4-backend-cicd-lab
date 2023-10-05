package com.example.demo.shop.entity;

import com.example.demo.item.Item;
import com.example.demo.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String shopName;
    @Column(name = "intro", nullable = false)
    private String shopIntro;
    @Column(name = "star_avg", nullable = false)
    private double star;

    @OneToMany(mappedBy = "item", orphanRemoval = true)
    private List<Item> itemList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Member member;


}
