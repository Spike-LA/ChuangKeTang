package com.example.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.framework.pojo.UserCourseRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserCourseRelationMapper extends BaseMapper<UserCourseRelation> {
    List<Map> retrieveSelectedCourseDependUserid(@Param("user_id") String user_id);
    List<Map> judgeCourseIsSelectedDependUseridCourseid(@Param("user_id") String user_id,@Param("course_id") String course_id);
    List<Map> retrieveAimedSelectedCourseDependUseridCoursename(@Param("user_id") String user_id,@Param("course_name") String course_id);
    List<Map> retrieveCourseDependCoursenameUsername(@Param("user_name") String user_name,@Param("course_name") String course_name);
}

