package com.hod0ri.catprice.api;

import com.hod0ri.catprice.admin.service.UserRequestService;
import com.hod0ri.catprice.admin.vo.UserRequestVO;
import com.hod0ri.catprice.item.service.ItemService;
import com.hod0ri.catprice.item.vo.ItemVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class APIController {

    final List<String> adminList = new ArrayList<>(Arrays.asList("cats_love", "zicotton", "whiteholes"));
    @Autowired
    ItemService itemService;

    @Autowired
    UserRequestService userRequestService;

    @PostMapping("/new")
    public void addNewItem(@RequestBody ItemVO item, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(adminList.contains((String) session.getAttribute("user_id"))) {

            log.info((String) session.getAttribute("user_id") + "님께서 아래 시세 내역을 강제로 추가하였습니다!");
            log.info(item.toString());
            userRequestService.uploadData(item);
        } else{
            itemService.addNewItem(item);
        }

    }

    @DeleteMapping("/delete")
    public String deleteItem(@RequestParam String name, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = session.getAttribute("user_id").toString();
        if(adminList.contains(userId)) {
            ItemVO data = itemService.getItemInfoByName(name);
            log.info(userId + "님께서 아래 시세 내용을 강제로 삭제하였습니다!");
            log.info(data.toString());
            itemService.deleteItem(name);
            return "successful";
        } else{
            return "authException";
        }
    }

    @PutMapping("/req")
    public void changeStatus(@RequestParam Integer id, @RequestParam String status, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userId = session.getAttribute("user_id").toString();
        UserRequestVO data = userRequestService.getUserRequest(id);

        if(status.equals("deny")) {
            log.info(userId + "님께서 아래 시세 정정/추가 요청을 반려하였습니다!");
            log.info(data.toString());
            userRequestService.denyRequest(id);
        } else if(status.equals("confirm")) {
            log.info(userId + "님께서 아래 시세 정정/추가 요청을 승인하였습니다!");
            log.info(data.toString());
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
