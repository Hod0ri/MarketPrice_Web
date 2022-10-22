package com.hod0ri.catprice.auth.service;

import com.hod0ri.catprice.auth.mapper.UserMapper;
import com.hod0ri.catprice.auth.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImple implements UserService{
    @Autowired
    private UserMapper mapper;
    @Override
    public void register(UserVO user) {
        mapper.register(user);
    }

    @Override
    public boolean findId(String userId) {
        return mapper.findId(userId);
    }

    @Override
    public String getpassword(String userId) {
        return mapper.getpassword(userId);
    }

    @Override
    public List<UserVO> getAllAdmin() {
        return mapper.getAllAdmin();
    }

    @Override
    public List<UserVO> getAllUser() {
        return mapper.getAllUser();
    }

    @Override
    public UserVO getUserInfo(String userId) {
        return mapper.getUserInfo(userId);
    }
}
