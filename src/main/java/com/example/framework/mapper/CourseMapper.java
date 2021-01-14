package com.example.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.framework.pojo.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CourseMapper extends BaseMapper<Course> {
    List<Map> getAllCreatedCourse(@Param("user_id") String user_id);
    List<Map> getCreatedCourseDependName(@Param("course_name") String course_name,@Param("user_id") String user_id);
}

