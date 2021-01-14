package com.example.framework.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.mapper.UserCourseRelationMapper;
import com.example.framework.pojo.UserCourseRelation;
import com.example.framework.service.UserCourseRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("UserCourseRelationService")
public class UserCourseRelationServiceImpl extends ServiceImpl<UserCourseRelationMapper, UserCourseRelation> implements UserCourseRelationService {

    @Autowired
    private UserCourseRelationMapper userCourseRelationMapper;

    @Override
    @Transactional
    public JSONObject selectCourseService(String user_id, String course_id){
        JSONObject resultImpl = new JSONObject();
        if (userCourseRelationMapper.judgeCourseIsSelectedDependUseridCourseid(user_id,course_id).size()>0){
            resultImpl.put("execute_result","已选择此课程");
        }else{
            UserCourseRelation userCourseRelation = new UserCourseRelation();
            userCourseRelation.setUser_id(user_id);
            userCourseRelation.setCourse_id(course_id);
            userCourseRelation.setStatus("1");
            int insertResult = userCourseRelationMapper.insert(userCourseRelation);
            if (insertResult==1){
                resultImpl.put("execute_result","选课成功");
            }else {
                resultImpl.put("execute_result","选课失败");
            }}
        return resultImpl;
    }

    @Override
    @Transactional
    public List<Map> retrieveSelectedCourseService(String user_id){
        List<Map> selectedCourseListImpl = userCourseRelationMapper.retrieveSelectedCourseDependUserid(user_id);
        return selectedCourseListImpl;
    }

    @Override
    @Transactional
    public JSONObject deleteCourseService(String user_id,String course_id){
        JSONObject resultImpl = new JSONObject();
        UpdateWrapper<UserCourseRelation> userCourseRelationUpdateWrapper = new UpdateWrapper<>();
        userCourseRelationUpdateWrapper.eq("user_id",user_id).eq("course_id",course_id);
        UserCourseRelation userCourseRelation = userCourseRelationMapper.selectOne(userCourseRelationUpdateWrapper);
        userCourseRelation.setStatus("0");
        int update = userCourseRelationMapper.update(userCourseRelation,userCourseRelationUpdateWrapper);
        if (update==1){
            resultImpl.put("execute_result","退课成功");
        }else {
            resultImpl.put("execute_result","退课失败");
        }
        return resultImpl;
    }

    @Override
    @Transactional
    public List<Map> retrieveAimedSelectedCourseService(String user_id, String course_name){
        List<Map> aimedSelectedCourseListImpl = userCourseRelationMapper.retrieveAimedSelectedCourseDependUseridCoursename(user_id,course_name);
        return aimedSelectedCourseListImpl;
    }

    @Override
    @Transactional
    public List<Map> retrieveCourseService(String user_name,String course_name){
        List<Map> retrieveCourseListImpl = userCourseRelationMapper.retrieveCourseDependCoursenameUsername(user_name,course_name);
        return retrieveCourseListImpl;
    }
}
