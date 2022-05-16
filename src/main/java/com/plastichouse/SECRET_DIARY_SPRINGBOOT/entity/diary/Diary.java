package com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.diary;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.BaseIdEntity;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary extends BaseIdEntity {

    @Column(length = 30)
    private String title;

    @Column(length = 450)
    private String content;

    @DateTimeFormat(pattern = "yyyy/MM/dd`T`HH:mm:ss")
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public static Diary createDiary(String title, String content, User user) {
        Diary diary = new Diary();
        diary.title = title;
        diary.content = content;
        diary.user = user;
        return diary;
    }

}
