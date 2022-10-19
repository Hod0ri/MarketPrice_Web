package com.hod0ri.catprice.auth.service;

import com.hod0ri.catprice.auth.vo.UserVO;

import java.util.List;

public interface UserService {
    void register(UserVO user);

    boolean findId(String userId);

    String getpassword(String userId);

    List<UserVO> getAllAdmin();

    List<UserVO> getAllUser();
}
