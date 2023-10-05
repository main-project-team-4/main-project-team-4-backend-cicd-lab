package com.example.demo.review;


import com.example.demo.entity.TimeStamp;
import com.example.demo.item.Item;
import com.example.demo.member.Member;
import com.example.demo.shop.entity.Shop;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="review")
@Getter
@Setter
@NoArgsConstructor
public class Review extends TimeStamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="comment", nullable = false, length = 500)
    private String comment;

    @Column(name="rating", nullable = false, length = 500)
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shop_id", nullable = false)
    private Shop shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id", nullable = false)
    private Member member;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id", nullable = false)
    private Item item;

    public Review(ReviewRequestDto requestDto, Shop shop, Member member, Item item ){
        this.comment = requestDto.getComment();
        this.shop = shop;
        this.item = item;
    }

    public void update(ReviewRequestDto requestDto, Member member){
        this.comment = requestDto.getComment();
        this.member = member;
    }
}
