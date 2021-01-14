package com.example.framework.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Component // 将处理器注入 IOC 容器
public class MyMetaObjectHandler implements MetaObjectHandler {
  // 插入时的填充策略
  @Override
  public void insertFill(MetaObject metaObject) {
    //获取执行插入操作时的uuid值
    String uuid = (String) getFieldValByName("uuid", metaObject);
    this.setFieldValByName("create_time", new Date(), metaObject);
    if (uuid == null) {
      this.setFieldValByName("uuid", UUID.randomUUID().toString().replaceAll("-", ""), metaObject);
    }
    // this.setFieldValByName("updated_date", new Date(), metaObject);
  }

  // 更新时的填充策略
  @Override
  public void updateFill(MetaObject metaObject) {
    this.setFieldValByName("updated_date", new Date(), metaObject);
  }
}
