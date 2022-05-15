package com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.diary;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.BaseIdEntity;
import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary extends BaseIdEntity {

    @Column(length = 30)
    private String title;

    @Column(length = 450)
    private String content;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
