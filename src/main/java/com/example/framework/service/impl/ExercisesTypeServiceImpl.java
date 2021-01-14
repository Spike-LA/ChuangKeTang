package com.example.framework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.mapper.ExerciseTypeMapper;
import com.example.framework.pojo.ExercisesType;
import com.example.framework.service.ExercisesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("ExercisesTypeService")
public class ExercisesTypeServiceImpl extends ServiceImpl<ExerciseTypeMapper, ExercisesType> implements ExercisesTypeService {

    @Autowired
    ExerciseTypeMapper exerciseTypeMapper;

    @Override
    @Transactional
    public void addExerciseType(String type_name){
        ExercisesType exercisesType = new ExercisesType();
        exercisesType.setType_name(type_name);
        exerciseTypeMapper.insert(exercisesType);
    }

    @Override
    @Transactional
    public List<Map> getExerciseType(){
        List<Map> maps = exerciseTypeMapper.textType();
        return maps;
    }
}
