package com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequest {

    @Schema(description = "유저의 PK", type = "number", required = true, example = "1")
    @NotNull
    private Integer userId;

}
