package com.example.easy.User;

import com.example.easy.Entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 로그인 기능 서비스
    public UserDTO getUserIdPassword(UserDTO userDTO) {
        System.out.println("[UserService] User loginConfirm()");
        // 비밀번호 해싱
        UserDTO result = convertDTO(userRepository.findByUserId(userDTO.getUserId()));
        if(result != null) {
          if(result.getUserPassword().equals(EncryptUtils.sha256(userDTO.getUserPassword()))) {
              System.out.println("[UserService] login ok!");
              return UserDTO.builder()
                      .userId(result.getUserId())
                      .userNickname(result.getUserNickname())
                      .build();
          } else {
              System.out.println("[UserService] password discord!");
              return UserDTO.builder()
                      .userId(result.getUserId())
                      .build();
          }
        } else {
            System.out.println("[UserService] ID discord!");
            return null;
        }
    }

    // 회원 가입 서비스
    public Integer addUser(UserDTO userDTO) {

        //비밀번호 해싱
        String hashed_password = EncryptUtils.sha256(userDTO.getUserPassword());
        // DTO -> Entity 변환
        UserEntity user = userRepository.save(
                UserEntity.builder()
                        .userId(userDTO.getUserId())
                        .userPassword(hashed_password)
                        .userNickname(userDTO.getUserNickname())
                        .userBirth(userDTO.getUserBirth())
                        .userTel(userDTO.getUserTel())
                        .build()
        );

        return user == null ? null : user.getUserNo();
        }

    private UserDTO convertDTO(UserEntity userEntity) {
        if(userEntity == null) {
            return null;
        }
        return UserDTO.builder()
                .userId(userEntity.getUserId())
                .userPassword(userEntity.getUserPassword())
                .userNickname(userEntity.getUserNickname())
                .userBirth(userEntity.getUserBirth())
                .userTel(userEntity.getUserTel())
                .build();
    }
}
