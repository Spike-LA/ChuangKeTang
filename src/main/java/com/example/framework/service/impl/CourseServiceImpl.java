package com.example.framework.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.mapper.CourseMapper;
import com.example.framework.pojo.Course;
import com.example.framework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("CourseService")
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    @Transactional
    public JSONObject addCourseService(String course_name, String create_by){

        JSONObject resultImpl = new JSONObject();
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        Course course = new Course();
        course.setUuid(uuid);
        course.setCourse_name(course_name);
        course.setCreate_by(create_by);
        course.setStatus("1");
        int resultInt = courseMapper.insert(course);
        if (resultInt==1){
            resultImpl.put("execute_result","创建成功");
        }else {
            resultImpl.put("execute_result","创建失败");
        }
        return resultImpl;

    }

    @Override
    @Transactional
    public JSONArray getAllCreatedCourseService(String user_id){
        List<Map> allCourse = courseMapper.getAllCreatedCourse(user_id);
        JSONArray listlmpl = JSONArray.parseArray(JSON.toJSONString(allCourse));
        return listlmpl;
    }

    @Override
    @Transactional
    public JSONArray getCreatedCourseDependNameService(String course_name,String user_id){
        List<Map> retrievedCourse = courseMapper.getCreatedCourseDependName(course_name,user_id);
        JSONArray listlmpl = JSONArray.parseArray(JSON.toJSONString(retrievedCourse));
        return listlmpl;
    }

    @Override
    @Transactional
    public JSONObject deleteAllCreatedCourseService(String course_id){
        JSONObject resultlmpl = new JSONObject();
        UpdateWrapper<Course> courseUpdateWrapper = new UpdateWrapper<>();
        courseUpdateWrapper.eq("uuid",course_id);
        Course course = courseMapper.selectOne(courseUpdateWrapper);
        course.setStatus("0");
        int update = courseMapper.update(course,courseUpdateWrapper);
        if (update==1){
            resultlmpl.put("execute_result","删除成功");
        }else{
            resultlmpl.put("execute_result","删除失败");
        }
        return resultlmpl;
    }
}
