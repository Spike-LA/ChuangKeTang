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
public class Question {
    @TableField(fill = FieldFill.INSERT)
    private String uuid;
    private String question_title;
    private String question_content;
    private String course_id;
    private String raise_person_id;
    private String receive_person_id;
    private String question_status;
    @TableField(fill = FieldFill.INSERT)
    private Date question_time;
}
