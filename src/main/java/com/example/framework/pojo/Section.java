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
public class Section {
    @TableField(fill = FieldFill.INSERT)
    private String uuid;
    private String section_name;
    private String course_id;
    private String create_by;
    @TableField(fill = FieldFill.INSERT)
    private Date create_time;
    private String status;//1为已录入章节，0为已删除章节
}
