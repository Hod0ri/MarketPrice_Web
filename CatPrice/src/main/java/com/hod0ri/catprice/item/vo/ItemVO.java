package com.hod0ri.catprice.item.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemVO {
    private String item_id;
    private String item_display;
    private Float max_price;
    private Float min_price;
    private Float avg_price;
}
