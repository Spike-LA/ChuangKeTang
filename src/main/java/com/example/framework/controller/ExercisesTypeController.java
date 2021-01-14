package com.example.framework.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.framework.service.ExercisesTypeService;
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
@Api(tags = "ExercisesType接口")
public class ExercisesTypeController {

    @Autowired
    ExercisesTypeService exercisesTypeService;

    @PostMapping("/addExercisesType")
    @ApiOperation("添加题型接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type_name", value = "题型名称", dataType = "string"),
    })
    public JSONObject addExercisesType(@RequestBody Map map){
        JSONObject result = new JSONObject();
        String type_name = (String) map.get("type_name");
        exercisesTypeService.addExerciseType(type_name);
        result.put("result", "创建成功");
        return result;
    }

    @PostMapping("/getExercisesType")
    @ApiOperation("所有题型接口")
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "type_name", value = "题型名称", dataType = "string"),
    })
    public JSONObject getExercisesType(){
        JSONObject result = new JSONObject();
        result.put("result", exercisesTypeService.getExerciseType());
        return result;
    }
}
