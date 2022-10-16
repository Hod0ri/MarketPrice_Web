package com.hod0ri.catprice.item.service;

import com.hod0ri.catprice.item.mapper.ItemMapper;
import com.hod0ri.catprice.item.vo.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemMapper mapper;

    @Override
    public List<ItemVO> getAllItems() {
        return mapper.getAllItems();
    }

    @Override
    public void addNewItem(ItemVO item) {
        mapper.addNewItem(item);
    }
}
