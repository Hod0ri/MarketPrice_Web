package com.hod0ri.catprice.auth.controller;

import com.hod0ri.catprice.auth.service.UserService;
import com.hod0ri.catprice.security.SHA256;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            if(cryptogram.equals(realPassword)) {
                HttpSession session = request.getSession();
                session.setAttribute("user_id", user_id);
                return "successful";
            } else {
                return "authexception";
            }
        } else {
            log.info("아이디 없음");
            return "cannotfindid";
        }

    }
}
