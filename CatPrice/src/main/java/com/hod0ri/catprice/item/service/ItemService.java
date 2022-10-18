package com.hod0ri.catprice.item.service;

import com.hod0ri.catprice.item.vo.ItemVO;

import java.util.List;

public interface ItemService {
    List<ItemVO> getAllItems();

    void addNewItem(ItemVO item);

    List<ItemVO> getItemByName(String name);
}
