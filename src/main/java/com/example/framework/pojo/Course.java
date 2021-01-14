package com.example.framework.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Course {
    @TableField(fill = FieldFill.INSERT)
    private String uuid;
    private String course_name;
    private String create_by;
    @TableField(fill = FieldFill.INSERT)
    private Date create_time;
    private String status;
}
