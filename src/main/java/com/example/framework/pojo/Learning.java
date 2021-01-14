package com.example.framework.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Learning {
  @TableField(fill = FieldFill.INSERT)
  private String uuid;
  @TableField(fill = FieldFill.INSERT)
  private Date created_time;
  private String name;
}
