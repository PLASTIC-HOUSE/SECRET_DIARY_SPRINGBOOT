package com.plastichouse.SECRET_DIARY_SPRINGBOOT.service;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.request.LoginRequest;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.user.User;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.user.UserRepository;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.NotFoundException;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.security.jwt.JwtProvider;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.security.jwt.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class LoginService {

    private final UserRepository userRepository;

    private final JwtProvider jwtProvider;

    public TokenResponse execute(LoginRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> {
                    throw NotFoundException.USER_NOT_FOUND;
                });

        return jwtProvider.generateToken(user.getNickname());
    }

}
