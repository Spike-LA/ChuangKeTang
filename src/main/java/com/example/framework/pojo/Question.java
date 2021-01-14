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
public class Question {
    @TableField(fill = FieldFill.INSERT)
    private String uuid;
    private String question_title;
    private String question_content;
    private String answer_content;
    private String course_id;
    private String raise_person_id;
    private String receive_person_id;
    @TableField(fill = FieldFill.INSERT)
    private Date question_time;
    private String question_status;//1是已回答，0是未回答

}
