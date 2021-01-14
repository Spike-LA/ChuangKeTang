package com.example.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.framework.pojo.Exercises;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ExerciseMapper extends BaseMapper<Exercises> {
    List<Map> textExercises();
    List<Map> textExercise(String course_id, String section_id, String create_time_gt, String create_time_lt);
}
