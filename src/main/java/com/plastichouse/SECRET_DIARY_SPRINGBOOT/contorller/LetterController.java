package com.plastichouse.SECRET_DIARY_SPRINGBOOT.contorller;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.request.WriteLetterRequest;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.response.GetDiaryListResponse;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.service.GetDiaryListService;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.service.WriteLetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/letter")
@RestController
public class LetterController {

    private final WriteLetterService writeLetterService;

    private final GetDiaryListService getDiaryListService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void writeLetter(@RequestBody @Valid WriteLetterRequest request) {
        writeLetterService.execute(request);
    }

    @GetMapping
    public GetDiaryListResponse getDiaryList() {
        return getDiaryListService.execute();
    }

}
