package com.plastichouse.SECRET_DIARY_SPRINGBOOT.contorller;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.service.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final RegisterService registerService;

    @Operation(tags = "계정", summary = "회원가입")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void register(@RequestParam String nickname,
                         @RequestParam List<MultipartFile> files) {
        registerService.register(nickname, files);
    }

}
