package com.plastichouse.SECRET_DIARY_SPRINGBOOT.contorller;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.request.WriteDiaryRequest;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.response.GetDiaryDetailsResponse;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.dto.response.GetDiaryListResponse;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.service.GetDiaryDetailsService;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.service.GetDiaryListService;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.service.WriteDiaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "일기", description = "일기 작성 및 가져오기")
@RequiredArgsConstructor
@RequestMapping("/letter")
@RestController
public class DiaryController {

    private final WriteDiaryService writeDiaryService;

    private final GetDiaryListService getDiaryListService;

    private final GetDiaryDetailsService getDiaryDetailsService;

    @Operation(tags = "일기", summary = "일기 작성")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void writeDiary(@RequestBody @Valid WriteDiaryRequest request) {
        writeDiaryService.execute(request);
    }

    @Operation(tags = "일기", summary = "일기 목록")
    @GetMapping
    public GetDiaryListResponse getDiaryList() {
        return getDiaryListService.execute();
    }

    @Operation(tags = "일기", summary = "일기 상세")
    @GetMapping("/{diary_id}")
    public GetDiaryDetailsResponse getDiaryDetails(@PathVariable("diary_id") int diaryId) {
        return getDiaryDetailsService.execute(diaryId);
    }

}
