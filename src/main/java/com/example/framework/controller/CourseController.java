package com.example.framework.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.framework.service.CourseService;
import com.example.framework.service.SectionService;
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
@Api(tags = "Course接口")
public class CourseController {

    @Autowired
    CourseService courseService;
    @PostMapping("/getCourse")
    @ApiOperation("获取课程接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户id", dataType = "string"),
    })
    public JSONObject getCourse(@RequestBody Map map){

        JSONObject result = new JSONObject();

        String user_id = (String) map.get("user_id");

        result.put("course", courseService.getCourse(user_id));

        return result;
    }
}
