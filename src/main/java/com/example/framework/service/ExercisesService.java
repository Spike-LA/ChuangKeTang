package com.example.framework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.framework.pojo.Exercise;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Repository
public interface ExercisesService extends IService<Exercise> {

    @Transactional
    int addExercises(String exercise_content, String exercise_type_id, String options, String answer, String section_id, String create_by);

    @Transactional
    List<Map> getExercises();

    @Transactional
    List<Map> getExercise(String course_id, String section_id, String create_time_gt, String create_time_lt);
}
