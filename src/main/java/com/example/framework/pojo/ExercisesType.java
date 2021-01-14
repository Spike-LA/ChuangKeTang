package com.example.framework.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ExercisesType {
    @TableField(fill = FieldFill.INSERT)
    private String uuid;
    private String type_name;
}
