package com.example.demo.util;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface FilterChainRing {
    void configure(HttpSecurity http) throws Exception;
}
