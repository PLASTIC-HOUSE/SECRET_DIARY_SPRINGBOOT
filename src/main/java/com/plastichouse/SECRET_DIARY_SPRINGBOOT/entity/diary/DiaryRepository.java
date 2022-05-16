package com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.diary;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiaryRepository extends CrudRepository<Diary, Integer> {
    List<Diary> findAllByUserOrderByCreatedAtDesc(User user);
}
