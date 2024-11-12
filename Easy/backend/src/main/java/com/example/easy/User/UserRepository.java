package com.example.easy.User;

import com.example.easy.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public UserEntity findByUserId(String userId);
    UserEntity findByUserIdAndUserPassword(String userId, String userPassword);
}
