package com.hod0ri.catprice.api;

import com.hod0ri.catprice.admin.service.UserRequestService;
import com.hod0ri.catprice.item.service.ItemService;
import com.hod0ri.catprice.item.vo.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            userRequestService.confirmRequest(id);
        }
    }
}
