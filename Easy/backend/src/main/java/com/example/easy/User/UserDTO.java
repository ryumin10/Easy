package com.example.easy.User;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private String userId;
    private String userPassword;
    private String userNickname;
    private String userBirth;
    private String userTel;
}
