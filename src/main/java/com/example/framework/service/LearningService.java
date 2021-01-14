package com.example.framework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.framework.pojo.Learning;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Repository
public interface LearningService extends IService<Learning> {
  void addLearning(Learning learning);


  @Transactional
  List<Map> getLearning(String name);
}
