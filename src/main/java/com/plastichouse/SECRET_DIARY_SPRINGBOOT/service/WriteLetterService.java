package com.plastichouse.SECRET_DIARY_SPRINGBOOT.service;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.request.WriteLetterRequest;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.diary.Diary;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.diary.DiaryRepository;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.user.User;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.facade.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class WriteLetterService {

    private final DiaryRepository diaryRepository;

    private final AuthenticationFacade authenticationFacade;

    public void execute(WriteLetterRequest request) {
        User user = authenticationFacade.getUser();

        diaryRepository.save(
                Diary.createDiary(
                        request.getTitle(),
                        request.getContent(),
                        user
                )
        );
    }

}
