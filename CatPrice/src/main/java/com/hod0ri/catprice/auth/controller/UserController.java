package com.hod0ri.catprice.auth.controller;

import com.hod0ri.catprice.auth.service.UserService;
import com.hod0ri.catprice.auth.service.UserServiceImple;
import com.hod0ri.catprice.auth.vo.UserVO;
import com.hod0ri.catprice.security.SHA256;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.NoSuchAlgorithmException;

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
}
