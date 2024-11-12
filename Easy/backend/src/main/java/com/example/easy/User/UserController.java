package com.example.easy.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    public UserService userService;

    // 로그인
    @GetMapping("/signin")
    public String Usersignin() {
        System.out.println("[UserController] UserSigninController()");
        return "로그인페이지";
    }

    @PostMapping("/loginconfirm")
    public Map<String, Object> loginconfirm(UserDTO userDTO,
                                            HttpServletRequest request) {
        System.out.println("[UserController] UserloginconfirmController()");

        UserDTO userSession = userService.getUserIdPassword(userDTO);

        //응답
        Map<String, Object> result = new HashMap<>();
        if(userSession != null) {
            if(userSession.getUserId() != null && userSession.getUserNickname() != null) {
                //세션에 저장
                HttpSession session = request.getSession();
                session.setAttribute("sessionInfo",userSession);
                result.put("code",200);
                result.put("result","성공");
            } else {
                result.put("code",401);
                result.put("result","비밀번호가 틀렸습니다.");
            }
        } else {
            result.put("code", 404);
            result.put("result","아이디가 존재하지 않습니다");
        }
        return result;
    }

    //회원가입
    @GetMapping("/signup")
    public String Usersignup() {
        System.out.println("[UserController] UserSignUpController()");
        return "회원가입페이지";
    }

    @PostMapping("/signupconfirm")
    public Map<String, Object> signupconfirm(UserDTO userDTO) {

        Map<String, Object> result = new HashMap<>();

        Integer userId = userService.addUser(userDTO);

        //응답값
        if(userId != null) {
            result.put("code", 200);
            result.put("result", "성공");
        } else {
            result.put("code", 500);
            result.put("error_message","회원가입에 실패했습니다.");
        }
        return result;
    }




}
