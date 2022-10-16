package com.hod0ri.catprice.auth.service;

import com.hod0ri.catprice.auth.mapper.UserMapper;
import com.hod0ri.catprice.auth.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService{
    @Autowired
    private UserMapper mapper;
    @Override
    public void register(UserVO user) {
        mapper.register(user);
    }
}
