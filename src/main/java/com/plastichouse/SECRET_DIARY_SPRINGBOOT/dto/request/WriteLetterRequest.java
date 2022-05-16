package com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WriteLetterRequest {

    @Length(min = 2, max = 30)
    private String title;

    @Length(min = 2, max = 450)
    private String content;

}
