package com.example.framework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.mapper.CourseMapper;
import com.example.framework.pojo.Course;
import com.example.framework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("CourseService")
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    @Transactional
    public List<Map> getCourse(String user_id){
        List<Map> maps = courseMapper.textCourse(user_id);
        return maps;
    }

}
