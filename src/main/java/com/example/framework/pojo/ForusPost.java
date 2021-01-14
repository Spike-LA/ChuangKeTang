package com.example.framework.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

public class ForusPost {
    @TableField(fill = FieldFill.INSERT)
    private String uuid;
    private String post_title;
    private String post_content;
    private String forum_id;
    private String create_by;
    @TableField(fill = FieldFill.INSERT)
    private Date create_time;
}
