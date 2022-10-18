package com.hod0ri.catprice.admin.service;

import com.hod0ri.catprice.admin.vo.UserRequestVO;
import com.hod0ri.catprice.item.vo.ItemVO;

import java.util.List;

public interface UserRequestService {
    List<UserRequestVO> getAllItems();

    void denyRequest(Integer id);

    void confirmRequest(Integer id);

    void uploadData(ItemVO item);

    UserRequestVO getUserRequest(Integer id);

    List<UserRequestVO> getRequestByName(String name);
}
