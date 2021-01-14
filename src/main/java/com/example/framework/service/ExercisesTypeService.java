package com.example.framework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.framework.pojo.ExercisesType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Repository
public interface ExercisesTypeService extends IService<ExercisesType> {

    @Transactional
    void addExerciseType(String type_name);

    @Transactional
    List<Map> getExerciseType();
}
