package com.example.framework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.mapper.ExerciseMapper;
import com.example.framework.pojo.Exercise;
import com.example.framework.service.ExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("ExercisesService")
public class ExercisesServiceImpl extends ServiceImpl<ExerciseMapper, Exercise> implements ExercisesService {

    @Autowired
    ExerciseMapper exerciseMapper;

    @Override
    @Transactional
    public int addExercises(String exercise_content, String exercise_type_id, String options, String answer, String section_id, String create_by){

        Exercise exercise = new Exercise();

        exercise.setExercise_content(exercise_content);
        exercise.setExercise_type_id(exercise_type_id);
        exercise.setOptions(options);
        exercise.setAnswer(answer);
        exercise.setSection_id(section_id);
        exercise.setCreate_by(create_by);
        exercise.setStatus("1");

        exerciseMapper.insert(exercise);

        return 1;
    }

    @Override
    @Transactional
    public List<Map> getExercises(){
        List<Map> maps = exerciseMapper.textExercises();
        return maps;
    }

    @Override
    @Transactional
    public List<Map> getExercise(String course_id, String section_id, String create_time_gt, String create_time_lt){
        List<Map> maps = exerciseMapper.textExercise(course_id,section_id,create_time_gt,create_time_lt);
        return maps;
    }
}
