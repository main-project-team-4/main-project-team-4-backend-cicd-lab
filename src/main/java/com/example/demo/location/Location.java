package com.example.demo.location;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address_one;

    public Location(String state, String city, String address_one) {
        this.id = getId();
        this.state = state;
        this.city = city;
        this.address_one = address_one;
    }
}
