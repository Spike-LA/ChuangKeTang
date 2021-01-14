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
public class CompleteExercise {
    @TableField(fill = FieldFill.INSERT)
    private String uuid;
    private String user_id;
    private String exercise_id;
    private String user_answer;
    private String answer_result;
    @TableField(fill = FieldFill.INSERT)
    private Date answer_time;
}
