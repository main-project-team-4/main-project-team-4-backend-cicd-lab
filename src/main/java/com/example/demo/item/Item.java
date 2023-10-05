package com.example.demo.item;

import com.example.demo.entity.TimeStamp;
import com.example.demo.shop.entity.Shop;
import com.example.demo.location.Location;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.URL;

@Entity
@Getter
@NoArgsConstructor
public class Item extends TimeStamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String comment;

    private URL image;

//    @ManyToOne
//    @JoinColumn(name = "location_id")
//    private Location location;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Item(String name, int price, String comment, URL image, Shop shop) {
        this.id = getId();
        this.shop = shop;
        this.name = name;
        this.price = price;
        this.comment = comment;
        this.image = image;
    }

    public void update(URL updatedImageUrlObject, String name, int price, String comment) {
        this.image = updatedImageUrlObject;
        this.name = name;
        this.price = price;
        this.comment = comment;
    }
}
