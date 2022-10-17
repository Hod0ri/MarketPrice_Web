package com.hod0ri.catprice.auth.controller;

import com.hod0ri.catprice.auth.service.UserService;
import com.hod0ri.catprice.auth.service.UserServiceImple;
import com.hod0ri.catprice.auth.vo.UserVO;
import com.hod0ri.catprice.security.SHA256;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register() {
        return "auth/UserRegister";
    }

    @PostMapping("/registration")
    public void registration(@RequestBody UserVO user) throws NoSuchAlgorithmException {
        SHA256 sha256 = new SHA256();
        user.setUser_password(sha256.encrypt(user.getUser_password()));

        userService.register(user);
    }

    @RequestMapping("/signup")
    public String signupPage(HttpServletRequest request) {
        return "auth/UserLogin";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam String user_id, @RequestParam String password, HttpServletRequest request, Model model) throws NoSuchAlgorithmException {
        SHA256 sha256 = new SHA256();
        String cryptogram = sha256.encrypt(password);

        if(userService.findId(user_id)) {
            String realPassword = userService.getpassword(user_id);
            if(cryptogram.equals(realPassword)) {
                log.info("로그인 성공");
                return "mg/index";
            } else {
                log.info("로그인 실패");
                model.addAttribute("status", "Authorization failed");
                return "auth/UserLogin";
            }
        } else {
            log.info("아이디 없음");
            return "no id";
        }
//        HttpSession session = request.getSession();
//        session.setAttribute("user_id", user_id);
    }
}
