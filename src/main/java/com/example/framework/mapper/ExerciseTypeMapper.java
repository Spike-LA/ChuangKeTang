package com.example.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.framework.pojo.ExercisesType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ExerciseTypeMapper extends BaseMapper<ExercisesType> {
    List<Map> textType();
}
