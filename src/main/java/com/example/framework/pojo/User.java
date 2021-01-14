package com.example.framework.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {
    @TableField(fill= FieldFill.INSERT)
    private String uuid;
    private String user_name;
    private String account;
    private String password;
    private String role_id;
    @TableField(fill= FieldFill.INSERT)
    private Date create_time;
    private String status; //1为登录状态,0为离线状态

}
