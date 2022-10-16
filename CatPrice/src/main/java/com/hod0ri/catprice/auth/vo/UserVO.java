package com.hod0ri.catprice.auth.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {

    private String user_id;

    private String user_name;

    private String user_password;
}
