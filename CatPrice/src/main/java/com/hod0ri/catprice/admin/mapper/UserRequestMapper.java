package com.hod0ri.catprice.admin.mapper;


import com.hod0ri.catprice.admin.vo.UserRequestVO;
import com.hod0ri.catprice.item.vo.ItemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRequestMapper {
    List<UserRequestVO> getAllItems();

    void denyRequest(Integer id);

    void confirmRequest(Integer id);
}
