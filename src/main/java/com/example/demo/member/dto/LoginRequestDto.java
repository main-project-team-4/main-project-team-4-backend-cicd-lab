package com.example.demo.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class LoginRequestDto {
    @Schema(description = "로그인할 유저의 아이디", example = "user1")
    private String username;
    @Schema(description = "로그인할 유저의 비밀번호", example = "1234")
    private String password;
}
