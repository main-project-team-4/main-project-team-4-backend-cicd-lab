package com.example.demo.item.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.net.URL;

@Getter
public class itemRequestDto {

    @Schema(description = "상품의 이름", example = "아비렉스 가죽자켓")
    @NotBlank(message = "상품의 이름을 입력해 주세요")
    @Size(min = 1,max = 30,message = "상품의 이름은 1~30자로 입력해 주세요")
    private String name;

    @Schema(description = "상품의 가격", example = "10000")
    @NotBlank(message = "상품의 가격을 입력해 주세요")
    private int price;

    @Schema(description = "상품 설명", example = "친칠라들이 좋아합니다!")
    @NotBlank(message = "상품 설명을 적어주세요")
    @Size(min = 1,max = 100,message = "상품의 설명은 1~100자로 입력해 주세요")
    private String comment;

}
