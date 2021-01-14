package com.example.framework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.mapper.LearningMapper;
import com.example.framework.pojo.Learning;
import com.example.framework.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("LearningService")
public class LearningServiceImpl extends ServiceImpl<LearningMapper, Learning> implements LearningService {

  @Autowired
  LearningMapper learningMapper;

  @Override
  @Transactional
  public void addLearning(Learning learning) {
    learningMapper.insert(learning);//插入数据
  }

  @Override
  @Transactional
  public List<Map> getLearning(String name){
    List<Map> maps = learningMapper.testXmlSql2(name);//执行自己写的sql语句
    return maps;
  }
}
