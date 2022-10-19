package com.hod0ri.catprice.item.mapper;

import com.hod0ri.catprice.item.vo.ItemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<ItemVO> getAllItems();

    void addNewItem(ItemVO item);

    List<ItemVO> getItemByName(String name);

    ItemVO getItemInfoByName(String name);

    void deleteItem(String name);
}
