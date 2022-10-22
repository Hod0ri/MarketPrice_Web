package com.hod0ri.catprice.auth.mapper;

import com.hod0ri.catprice.auth.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void register(UserVO user);

    boolean findId(String userId);

    String getpassword(String userId);

    List<UserVO> getAllAdmin();

    List<UserVO> getAllUser();

    UserVO getUserInfo(String userId);
}
