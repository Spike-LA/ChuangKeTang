package com.example.framework.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.framework.pojo.Course;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface CourseService extends IService<Course> {
    JSONObject addCourseService(String course_name, String create_by);
    JSONArray getAllCreatedCourseService(String user_id);
    JSONArray getCreatedCourseDependNameService(String course_name,String user_id);
    JSONObject deleteAllCreatedCourseService(String course_id);
}
