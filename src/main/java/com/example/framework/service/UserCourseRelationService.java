package com.example.framework.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.framework.pojo.UserCourseRelation;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Repository
public interface UserCourseRelationService extends IService<UserCourseRelation> {
    JSONObject selectCourseService(String user_id,String course_id);
    List<Map> retrieveSelectedCourseService(String user_id);
    JSONObject deleteCourseService(String user_id,String course_id);
    List<Map> retrieveAimedSelectedCourseService(String user_id, String course_name);
    List<Map> retrieveCourseService(String user_name,String course_name);
}
