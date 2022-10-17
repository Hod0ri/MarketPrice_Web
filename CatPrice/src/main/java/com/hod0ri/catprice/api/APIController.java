package com.hod0ri.catprice.api;

import com.hod0ri.catprice.admin.service.UserRequestService;
import com.hod0ri.catprice.admin.vo.UserRequestVO;
import com.hod0ri.catprice.item.service.ItemService;
import com.hod0ri.catprice.item.vo.ItemVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class APIController {

    @Autowired
    ItemService itemService;

    @Autowired
    UserRequestService userRequestService;

    @PostMapping("/new")
    public void addNewItem(@RequestBody ItemVO item) {
        itemService.addNewItem(item);
    }

    @PutMapping("/req")
    public void changeStatus(@RequestParam Integer id, @RequestParam String status) {
        if(status.equals("deny")) {
            userRequestService.denyRequest(id);
        } else if(status.equals("confirm")) {
            UserRequestVO data = userRequestService.getUserRequest(id);

            ItemVO item = ItemVO.builder()
                            .item_id(data.getItem_id())
                                    .item_display(data.getItem_display())
                                            .max_price(data.getMax_price())
                                                    .min_price(data.getMin_price())
                                                            .avg_price(data.getAvg_price())
                                                                    .build();
            userRequestService.confirmRequest(id);
            userRequestService.uploadData(item);
        }
    }
}
