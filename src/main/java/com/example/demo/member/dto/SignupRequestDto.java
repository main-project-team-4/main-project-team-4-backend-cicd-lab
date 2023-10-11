package com.example.demo.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import jakarta.validation.constraints.Pattern;

@Getter
public class SignupRequestDto {

    @Schema(description = "유저의 아이디", example = "user1")
    private String username;

    //    @Pattern(
//            regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
//            message = "password는  최소 8자 이상, 20자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9), 특수문자로 구성되어야 한다."
//    )
    @Schema(description = "유저의 비밀번호", example = "1234")
    private String password;

    @Schema(description = "유저의 닉네임", example = "고기닭고기")
    private String nickname;

    @Schema(description = "유저의 전화번호", example = "010-1234-5678")
    private String phoneNum;

    @Schema(description = "유저의 전화번호 확인", example = "010-1234-5678")
    private String phoneNum_check;

    @Schema(description = "유저의 주소", example = "경기도 광명시")
    private String location;


}