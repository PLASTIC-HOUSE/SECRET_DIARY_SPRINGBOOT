package com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.user;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseIdEntity {

    @Column(length = 30, nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String imageUrl;

}
