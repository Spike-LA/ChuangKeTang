package com.example.framework.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.framework.service.ExercisesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Api(tags = "Exercises接口")
public class ExercisesController {

    @Autowired
    ExercisesService exercisesService;

    @PostMapping("/addExercises")
    @ApiOperation("添加题目接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "exercise_content", value = "题目内容", dataType = "string"),
            @ApiImplicitParam(name = "exercise_type_id", value = "题目类型id", dataType = "string"),
            @ApiImplicitParam(name = "options", value = "选项", dataType = "string"),
            @ApiImplicitParam(name = "answer", value = "正确答案", dataType = "string"),
            @ApiImplicitParam(name = "section_id", value = "章节id", dataType = "string"),
            @ApiImplicitParam(name = "create_by", value = "创建人id", dataType = "string"),
    })
    public JSONObject addExercises(@RequestBody Map map){
        JSONObject result = new JSONObject();

        String exercise_content = (String) map.get("exercise_content");
        String exercise_type_id = (String) map.get("exercise_type_id");
        String options = (String) map.get("options");
        String answer = (String) map.get("answer");
        String section_id = (String) map.get("section_id");
        String create_by = (String) map.get("create_by");

        int i = exercisesService.addExercises(exercise_content, exercise_type_id, options, answer, section_id, create_by);
        if (i==1){
            result.put("status", "创建成功");
        } else {
            result.put("status", "创建失败");
        }
        return result;
    }

    @PostMapping("/getExercises")
    @ApiOperation("查询全部题目接口")
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "course_id", value = "课程id", dataType = "string"),
//            @ApiImplicitParam(name = "section_id", value = "章节id", dataType = "string"),
//            @ApiImplicitParam(name = "create_time", value = "创建时间", dataType = "string"),
    })
    public JSONObject getExercises(){

        JSONObject result = new JSONObject();

//        String course_id = (String) map.get("course_id");
//        String section_id = (String) map.get("section_id");
//        String create_time = (String) map.get("create_time");

        result.put("exercises", exercisesService.getExercises());

        return result;
    }

    @PostMapping("/getExercise")
    @ApiOperation("查询题目接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course_id", value = "课程id", dataType = "string"),
            @ApiImplicitParam(name = "section_id", value = "章节id", dataType = "string"),
            @ApiImplicitParam(name = "create_time_gt", value = "大创建时间", dataType = "string"),
            @ApiImplicitParam(name = "create_time_lt", value = "小创建时间", dataType = "string"),
    })
    public JSONObject getExercise(@RequestBody Map map){

        JSONObject result = new JSONObject();

        String course_id = (String) map.get("course_id");
        String section_id = (String) map.get("section_id");
        String create_time_gt = (String) map.get("create_time_gt");
        String create_time_lt = (String) map.get("create_time_lt");

        result.put("exercises", exercisesService.getExercise(course_id,section_id,create_time_gt,create_time_lt));

        return result;
    }
}
