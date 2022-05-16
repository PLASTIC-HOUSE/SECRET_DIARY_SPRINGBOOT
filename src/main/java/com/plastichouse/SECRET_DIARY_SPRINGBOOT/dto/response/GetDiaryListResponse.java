package com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetDiaryListResponse {

    private final List<DiaryDto> diaries;

    @Getter
    @Builder
    public static class DiaryDto {

        private final Integer id;

        private final String title;

    }

}
