package com.hod0ri.catprice.admin.service;

import com.hod0ri.catprice.admin.vo.UserRequestVO;
import com.hod0ri.catprice.item.vo.ItemVO;

import java.util.List;

public interface UserRequestService {
    List<UserRequestVO> getAllItems();
}
