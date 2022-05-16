package com.plastichouse.SECRET_DIARY_SPRINGBOOT.service;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.response.GetDiaryDetailsResponse;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.diary.Diary;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.diary.DiaryRepository;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.user.User;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.NotFoundException;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.exception.UnAuthorizedException;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.facade.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class GetDiaryDetailsService {

    private final DiaryRepository diaryRepository;

    private final AuthenticationFacade authenticationFacade;

    public GetDiaryDetailsResponse execute(int diaryId) {
        User user = authenticationFacade.getUser();

        Diary diary = diaryRepository.findById(diaryId)
                .orElseThrow(() -> {
                    throw NotFoundException.DIARY_NOT_FOUND;
                });

        if (!diary.getUser().equals(user)) {
            throw UnAuthorizedException.NOT_AUTHENTICATED;
        }

        return GetDiaryDetailsResponse.builder()
                .title(diary.getTitle())
                .content(diary.getContent())
                .createdAt(diary.getCreatedAt())
                .build();
    }

}
