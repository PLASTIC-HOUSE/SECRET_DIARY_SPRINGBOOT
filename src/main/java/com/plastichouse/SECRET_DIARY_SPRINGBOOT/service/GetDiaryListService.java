package com.plastichouse.SECRET_DIARY_SPRINGBOOT.service;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.response.GetDiaryListResponse;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.response.GetDiaryListResponse.DiaryDto;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.diary.DiaryRepository;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.user.User;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.facade.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetDiaryListService {

    private final DiaryRepository diaryRepository;

    private final AuthenticationFacade authenticationFacade;

    public GetDiaryListResponse execute() {
        User user = authenticationFacade.getUser();

        List<DiaryDto> diaries = diaryRepository.findAllByUserOrderByCreatedAtDesc(user).stream().map(
                d -> DiaryDto.builder()
                            .id(d.getId())
                            .title(d.getTitle())
                            .build()
        ).collect(Collectors.toList());

        return new GetDiaryListResponse(diaries);
    }

}
