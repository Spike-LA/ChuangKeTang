package com.example.framework.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserCourseRelation {
    @TableField(fill = FieldFill.INSERT)
    private String uuid;
    private String user_id;
    private String course_id;
    private String create_time;
    @TableField(fill = FieldFill.INSERT)
    private String status;
}
