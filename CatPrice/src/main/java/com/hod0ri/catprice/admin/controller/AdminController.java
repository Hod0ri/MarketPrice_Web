package com.hod0ri.catprice.admin.controller;

import com.hod0ri.catprice.admin.service.UserRequestService;
import com.hod0ri.catprice.admin.vo.UserRequestVO;
import com.hod0ri.catprice.auth.service.UserService;
import com.hod0ri.catprice.auth.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("management")
public class AdminController {
    // Manager List
    final List<String> adminList = new ArrayList<>(Arrays.asList("cats_love", "zicotton", "whiteholes"));

    @Autowired
    UserRequestService service;

    @RequestMapping("")
    public String index(HttpServletRequest request, Model model, @RequestParam(required = false) String name) throws Exception {
        HttpSession session = request.getSession();

        if(adminList.contains((String) session.getAttribute("user_id"))) {
            if(name == null) {
                List<UserRequestVO> itemList = service.getAllItems();
                model.addAttribute("itemList", itemList);
                return "admin/AdminPage";
            } else {
                List<UserRequestVO> itemList = service.getRequestByName(name);
                model.addAttribute("itemList", itemList);
                return "admin/AdminPage";
            }
        } else {
            return "mg/error/AuthException";
        }

    }
}
