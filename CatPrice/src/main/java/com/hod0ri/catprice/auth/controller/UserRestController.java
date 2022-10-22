package com.hod0ri.catprice.auth.controller;

import com.hod0ri.catprice.auth.service.UserService;
import com.hod0ri.catprice.auth.vo.UserVO;
import com.hod0ri.catprice.security.SHA256;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Slf4j
@RestController
@RequestMapping("authapi")
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String loginPage(@RequestParam String user_id, @RequestParam String password, HttpServletRequest request) throws NoSuchAlgorithmException {
        SHA256 sha256 = new SHA256();
        String cryptogram = sha256.encrypt(password);

        if(userService.findId(user_id)) {
            String realPassword = userService.getpassword(user_id);
            UserVO user = userService.getUserInfo(user_id);
            if(cryptogram.equals(realPassword)) {
                HttpSession session = request.getSession();
                session.setAttribute("user_id", user_id);
                log.info(user.getUser_name() + "님의 계정으로 세션이 생성되었습니다! -> 로그인");
                return "successful";
            } else {
                log.info(user.getUser_name() + "님의 계정으로 로그인 시도가 있었으나 실패했습니다! -> 로그인 실패");
                return "authexception";
            }
        } else {
            log.info("아이디 없음");
            return "cannotfindid";
        }

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String user_id = (String) session.getAttribute("user_id");
        UserVO user = userService.getUserInfo(user_id);
        log.info(user.getUser_name() + "님의 계정의 세션이 해제되었습니다! -> 로그아웃");
        session.removeAttribute("user_id");
        session.invalidate();
        return "successful";
    }
}
