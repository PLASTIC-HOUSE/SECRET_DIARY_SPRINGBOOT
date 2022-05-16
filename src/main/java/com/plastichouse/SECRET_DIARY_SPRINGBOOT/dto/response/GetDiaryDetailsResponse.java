package com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class GetDiaryDetailsResponse {

    private final String title;

    private final String content;

    private final LocalDateTime createdAt;

}
