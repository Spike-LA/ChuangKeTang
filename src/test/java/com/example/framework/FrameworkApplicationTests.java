package com.example.framework;

import com.example.framework.mapper.LearningMapper;
import com.example.framework.pojo.Learning;
import com.example.framework.service.LearningService;
import com.example.framework.service.impl.LearningServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class FrameworkApplicationTests {

  @Autowired
  private LearningMapper learningMapper;

  @Autowired
  LearningService learningService;

  @Test
  void test() {
    Learning learning = new Learning();
    learning.setName("testService");
    learningService.addLearning(learning);
  }

  @Test
  void contextLoads() {
    Learning learning = new Learning();
    learning.setName("test");
    learningMapper.insert(learning);
  }

  @Test
  void testXml() {
    List<Map> maps = learningMapper.testXmlSql();
    for (Map map : maps) {
      System.out.println(map.toString());
    }
  }

}
