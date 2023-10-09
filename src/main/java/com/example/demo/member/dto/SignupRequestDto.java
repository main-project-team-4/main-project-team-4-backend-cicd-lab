package com.example.demo.member.dto;

import lombok.Getter;
import jakarta.validation.constraints.Pattern;

@Getter
public class SignupRequestDto {


    private String username;

    //    @Pattern(
//            regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
//            message = "password는  최소 8자 이상, 20자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9), 특수문자로 구성되어야 한다."
//    )
    private String password;

    private String nickname;

    private String phoneNum;

    private String phoneNum_check;

    private String location;


}