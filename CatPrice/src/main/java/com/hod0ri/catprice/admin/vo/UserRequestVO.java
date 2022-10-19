package com.hod0ri.catprice.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestVO {

    private Long id;

    private String item_id;

    private String item_display;

    private Float min_price;
    private Float max_price;
    private Float avg_price;

    private String req_status;
}
