package com.hod0ri.catprice.mg.Controller;

import com.hod0ri.catprice.item.service.ItemService;
import com.hod0ri.catprice.item.vo.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("")
public class MainController {
    @Autowired
    ItemService itemService;

    @RequestMapping("")
    public String mainpage(Model model, @RequestParam(required = false) String name) {
        if(name == null) {
            List<ItemVO> itemList = itemService.getAllItems();
            model.addAttribute("itemList", itemList);
            return "mg/index";
        } else {
            List<ItemVO> itemList = itemService.getItemByName(name);
            model.addAttribute("itemList", itemList);
            return "mg/index";
        }
    }

    @RequestMapping("/new")
    public String insertItem() {
        return "item/inputNewItem";
    }
}
