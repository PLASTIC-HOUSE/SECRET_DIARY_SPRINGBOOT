package com.plastichouse.SECRET_DIARY_SPRINGBOOT.config;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.handler.GlobalExceptionHandlingFilter;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.security.auth.AuthenticationProvider;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.security.jwt.JwtFilter;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfiguration extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtProvider jwtProvider;
    private final AuthenticationProvider authenticationProvider;

    @Override
    public void configure(HttpSecurity builder) {
        JwtFilter jwtFilter = new JwtFilter(jwtProvider, authenticationProvider);
        GlobalExceptionHandlingFilter exceptionHandlingFilter = new GlobalExceptionHandlingFilter();

        builder.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        builder.addFilterBefore(exceptionHandlingFilter, JwtFilter.class);
    }

}
