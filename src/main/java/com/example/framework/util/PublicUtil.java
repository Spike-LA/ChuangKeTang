package com.example.framework.util;

import org.springframework.stereotype.Component;

@Component
public class PublicUtil {
  public static String test() {
    System.out.println("test");
    return "test";
  }
}
