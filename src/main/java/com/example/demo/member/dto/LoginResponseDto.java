package com.example.demo.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class LoginResponseDto {
    @Schema(description = "로그인 성공 여부", example = "로그인 성공")
    private String msg;
}
