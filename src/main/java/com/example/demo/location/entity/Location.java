package com.example.demo.location.entity;

import com.example.demo.location.dto.CoordinateVo;
import com.example.demo.location.dto.LocationRequestDto;
import com.example.demo.location.listener.LocationListener;
import com.example.demo.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@EntityListeners({LocationListener.class})
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "latitude")
    private Long latitude;

    @Column(name = "longitude")
    private Long longitude;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Location(LocationRequestDto requestDto, Member member) {
        this.id = getId();
        this.name = requestDto.getName();
        this.member = member;
    }

    public Location(String location) {
        this.name = location;
    }

    public void setCoordinates(CoordinateVo coordinates) {
        this.setLatitude(coordinates.Latitude());
        this.setLongitude(coordinates.Longitude());
    }

    public boolean hasCoordinates() {
        return hasValue(this.latitude) && hasValue(this.longitude);
    }

    private static boolean hasValue(Long value) {
        return value != null && !value.equals(0L);
    }

}
