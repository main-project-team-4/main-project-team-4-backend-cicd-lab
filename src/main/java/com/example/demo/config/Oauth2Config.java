package com.example.demo.config;

import com.example.demo.util.FilterChainRing;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@RequiredArgsConstructor
public class Oauth2Config {

    @Bean
    public FilterChainRing configureOauth2Config() {
        return http -> http
                .authorizeHttpRequests(b -> b
                        .requestMatchers(antMatcher(HttpMethod.POST, "/api/auth/*/callback")).permitAll()
                );
    }
}
