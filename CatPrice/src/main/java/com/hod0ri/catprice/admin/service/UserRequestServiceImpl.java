package com.hod0ri.catprice.admin.service;

import com.hod0ri.catprice.admin.mapper.UserRequestMapper;
import com.hod0ri.catprice.admin.vo.UserRequestVO;
import com.hod0ri.catprice.item.vo.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRequestServiceImpl implements UserRequestService {

    @Autowired
    UserRequestMapper mapper;

    @Override
    public List<UserRequestVO> getAllItems() {
        return mapper.getAllItems();
    }

    @Override
    public void denyRequest(Integer id) {
        mapper.denyRequest(id);
    }

    @Override
    public void confirmRequest(Integer id) {
        mapper.confirmRequest(id);
    }
}
