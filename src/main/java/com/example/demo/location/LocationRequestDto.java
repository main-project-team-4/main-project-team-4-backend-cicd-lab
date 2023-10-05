package com.example.demo.location;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationRequestDto {

    private String state;
    private String city;
    private String address_one;
}
