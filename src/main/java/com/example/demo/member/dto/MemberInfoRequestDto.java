package com.example.demo.member.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberInfoRequestDto {
    @Schema(description = "유저의 아이디", example = "user1")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "올바른 이메일 형식이 아닙니다.")
    private String username;
    @Schema(description = "유저의 닉네임", example = "고기닭고기")
    @NotBlank(message = "자기소개를 입력해 주세요.")
    private String nickname;

}
