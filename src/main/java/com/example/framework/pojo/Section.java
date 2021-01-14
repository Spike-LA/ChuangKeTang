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
public class Section {
    @TableField(fill = FieldFill.INSERT)
    private String uuid;
    private String section_name;
    private String course_id;
    private String create_by;
    private String status;
    @TableField(fill = FieldFill.INSERT)
    private Date create_time;

}
