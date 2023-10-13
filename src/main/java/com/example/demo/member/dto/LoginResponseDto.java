package com.example.demo.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class LoginResponseDto {
    @Schema(description = "로그인 성공 여부", example = "로그인 성공")
    private String msg;

    @Schema(description = "JWT 토큰", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6Iuq5gOyyoOyImCIsImV4cCI6IjQ4NjI1OTU4IiwiaWF0IjoiNDg2MjU1NTgifQ.2IA1NY1pWessf7MI3RTgwlMnPhGmMf_z-vhJc9dshGo")
    private String token;

    @Schema(description = "최초 회원 가입 여부", example = "true")
    private boolean first;
}
