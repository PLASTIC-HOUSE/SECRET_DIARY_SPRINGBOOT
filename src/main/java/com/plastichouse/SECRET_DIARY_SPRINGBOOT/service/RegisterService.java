package com.plastichouse.SECRET_DIARY_SPRINGBOOT.service;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.user.User;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.user.UserRepository;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.BadRequestException;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.facade.MergedImageFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class RegisterService {

    private final UserRepository userRepository;

    private final MergedImageFacade mergedImageFacade;

    public void register(String nickname, List<MultipartFile> files) {
        if (files != null && files.size() != 5) {
                throw BadRequestException.INVALID_FILE_REQUEST;
        }

        String imageUrl = mergedImageFacade.getMergedImagePath(files);

        userRepository.save(
                User.createUser(
                        nickname,
                        imageUrl
                )
        );
    }

}
