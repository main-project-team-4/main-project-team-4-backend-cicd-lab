package com.example.demo.trade;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter @RequiredArgsConstructor
public enum State {
    SELLING("판매중"),
    RESERVED("예약중"),
    SOLDOUT("판매 완료");

    private final String description;
}
