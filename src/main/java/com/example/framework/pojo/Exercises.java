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
public class Exercises {
    @TableField(fill = FieldFill.INSERT)
    private String uuid;
    private String exercise_content;
    private String exercise_type_id;
    private String options;
    private String answer;
    private String section_id;
    private String create_by;
    @TableField(fill = FieldFill.INSERT)
    private Date create_time;
    private String status;
}
