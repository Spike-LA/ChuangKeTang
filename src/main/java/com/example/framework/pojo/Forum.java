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
public class Forum {
    @TableField(fill = FieldFill.INSERT)
    private String uuid;
    private String forum_name;
    private String create_by;
    @TableField(fill = FieldFill.INSERT)
    private Date create_time;
}
