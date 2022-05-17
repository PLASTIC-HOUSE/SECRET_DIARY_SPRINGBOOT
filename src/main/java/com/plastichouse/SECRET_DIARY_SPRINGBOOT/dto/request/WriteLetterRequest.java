package com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WriteLetterRequest {

    @Schema(description = "제목", minLength = 2, maxLength = 30, required = true)
    @Length(min = 2, max = 30)
    private String title;

    @Schema(description = "내용", minLength = 2, maxLength = 450, required = true)
    @Length(min = 2, max = 450)
    private String content;

}
