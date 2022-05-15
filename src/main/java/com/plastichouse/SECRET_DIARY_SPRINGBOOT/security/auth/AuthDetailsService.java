package com.plastichouse.SECRET_DIARY_SPRINGBOOT.security.auth;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.user.UserRepository;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public AuthDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        userRepository.findByNickname(nickname)
                .orElseThrow(() -> NotFoundException.USER_NOT_FOUND);

        return new AuthDetails(nickname);
    }

}
