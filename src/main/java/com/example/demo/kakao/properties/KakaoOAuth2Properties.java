package com.example.demo.kakao.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter @NoArgsConstructor
public class KakaoOAuth2Properties {
    @Value("${auth.oauth2.kakao.client-id}")
    private String clientId;
    @Value("${auth.oauth2.kakao.redirect-url}")
    private String redirectUrl;
}
