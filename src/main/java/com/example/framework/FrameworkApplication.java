package com.example.framework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.framework.mapper"})
public class FrameworkApplication {

  public static void main(String[] args) {
    SpringApplication.run(FrameworkApplication.class, args);
  }

}
