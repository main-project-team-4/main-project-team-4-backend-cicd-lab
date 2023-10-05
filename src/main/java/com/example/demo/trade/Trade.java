package com.example.demo.trade;

import com.example.demo.item.Item;
import jakarta.persistence.*;
import com.example.demo.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "trade")
@Getter @Setter @NoArgsConstructor
public class Trade {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "seller_id")
    private String sellerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private State state;
}
