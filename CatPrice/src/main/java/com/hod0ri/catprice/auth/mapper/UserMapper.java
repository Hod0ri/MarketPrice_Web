package com.hod0ri.catprice.auth.mapper;

import com.hod0ri.catprice.auth.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void register(UserVO user);

    boolean findId(String userId);

    String getpassword(String userId);
}
