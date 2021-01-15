package com.example.framework.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.framework.pojo.Exercises;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ExerciseMapper extends BaseMapper<Exercises> {
    List<Map> textExercise(String user_id, String course_id, String section_id, String create_time_gt, String create_time_lt);
    IPage<Map> textExercise1(Page<Map> page, @Param(Constants.WRAPPER) QueryWrapper<Map> wrapper);
}
