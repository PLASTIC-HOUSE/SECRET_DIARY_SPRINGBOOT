package com.plastichouse.SECRET_DIARY_SPRINGBOOT.contorller;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.request.LoginRequest;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.security.jwt.TokenResponse;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "계정", description = "토큰 발급에 대한 API")
@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final LoginService loginService;

    @Operation(tags = "계정", summary = "로그인")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }

}
