package com.example.demo.item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.net.URL;

@Getter
public class itemRequestDto {
    @NotNull(message = "상점 ID는 필수 입니다.")
    private Long shopId;

    @NotBlank(message = "상품의 이름을 입력해 주세요")
    @Size(min = 1,max = 30,message = "상품의 이름은 1~30자로 입력해 주세요")
    private String name;

    @NotBlank(message = "상품의 가격을 입력해 주세요")
    private int price;

    private URL image;

    @NotBlank(message = "상품 설명을 적어주세요")
    @Size(min = 1,max = 100,message = "상품의 설명은 1~100자로 입력해 주세요")
    private String comment;
}
