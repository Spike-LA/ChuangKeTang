package com.example.framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.mapper.ExerciseMapper;
import com.example.framework.pojo.Exercises;
import com.example.framework.service.ExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("ExercisesService")
public class ExercisesServiceImpl extends ServiceImpl<ExerciseMapper, Exercises> implements ExercisesService {

    @Autowired
    ExerciseMapper exerciseMapper;

    @Override
    @Transactional
    public int addExercises(String exercise_content, String exercise_type_id, String options, String answer, String section_id, String create_by){

        Exercises exercise = new Exercises();

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
    public List<Map> getExercise(Integer current, Integer size, String user_id, String course_id, String section_id, String create_time_gt, String create_time_lt){
//        List<Map> maps = exerciseMapper.textExercise(user_id,course_id,section_id,create_time_gt,create_time_lt);
        Page<Map> page = new Page<>(current, size);
        QueryWrapper<Map> wrapper =new QueryWrapper<>();
        if (StringUtils.isNotBlank(user_id)){
            wrapper.eq("exercise.create_by", user_id);
        }
        if (StringUtils.isNotBlank(course_id)){
            wrapper.eq("course_id", course_id);
        }
        if (StringUtils.isNotBlank(section_id)){
            wrapper.eq("section_id", section_id);
        }
        if (StringUtils.isNotBlank(create_time_gt)){
            wrapper.ge("exercise.create_time", create_time_gt);
        }
        if (StringUtils.isNotBlank(create_time_lt)){
            wrapper.le("exercise.create_time", create_time_lt);
        }
        exerciseMapper.textExercise1(page,wrapper);
        List<Map> maps = page.getRecords();//结果
        return maps;
    }
}
