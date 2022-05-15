package com.plastichouse.SECRET_DIARY_SPRINGBOOT.facade;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.user.User;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.user.UserRepository;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.NotFoundException;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.UnAuthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticationFacade {

    private final UserRepository userRepository;

    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw UnAuthorizedException.NOT_AUTHENTICATED;
        }

        return userRepository.findByNickname(authentication.getName())
                .orElseThrow(() -> {
                    throw NotFoundException.USER_NOT_FOUND;
                });
    }

}
