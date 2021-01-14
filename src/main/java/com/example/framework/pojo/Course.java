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
public class Course {
    private String uuid;
    private String course_name;
    @TableField(fill=FieldFill.INSERT)
    private Date create_time;
    private String create_by;
    private String status;//0为已删除课程,1是未删除课程
}
