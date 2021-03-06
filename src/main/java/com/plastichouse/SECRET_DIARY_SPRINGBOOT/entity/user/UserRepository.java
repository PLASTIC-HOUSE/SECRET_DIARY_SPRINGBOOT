package com.plastichouse.SECRET_DIARY_SPRINGBOOT.entity.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByNickname(String nickname);
}
