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
public class UserCourseRelation {
    @TableField(fill = FieldFill.INSERT)
    private String uuid;
    private String user_id;
    private String course_id;
    @TableField(fill = FieldFill.INSERT)
    private Date create_time;
    private String status;//1代表用户选择/创建了这个课，0代表用户选择/创建的课程结束或已退课
}
