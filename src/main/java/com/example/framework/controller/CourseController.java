package com.example.framework.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.framework.service.CourseService;
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
    private CourseService courseService;

    @PostMapping("/addCourse")
    @ApiOperation("课程添加接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="course_name",value = "课程名称",dataType = "string"),
            @ApiImplicitParam(name="create_by",value = "添加人id",dataType = "string"),
    })
    public JSONObject addCourse(@RequestBody Map map){
        String course_name = (String)map.get("course_name");
        String create_by = (String)map.get("create_by");
        JSONObject result = courseService.addCourseService(course_name,create_by);
        return result;
    }

    @PostMapping("/getAllCreatedCourse")
    @ApiOperation("获取已创建课程接口")
    public JSONArray getAllCreatedCourse(@RequestBody Map map) {
        String user_id = (String)map.get("user_id");
        JSONArray list = courseService.getAllCreatedCourseService(user_id);
        return list;
    }

    @PostMapping("/getCreatedCourseDependName")
    @ApiOperation("根据课程名称获取课程接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="course_name",value = "课程名称",dataType = "string"),
            @ApiImplicitParam(name="user_id",value = "用户id",dataType = "string"),
    })
    public JSONArray getCreatedCourseDependName(@RequestBody Map map) {
        String course_name = (String)map.get("course_name");
        String user_id = (String)map.get("user_id");
        JSONArray list = courseService.getCreatedCourseDependNameService(course_name,user_id);
        return list;
    }

    @PostMapping("/deleteCreatedCourse")
    @ApiOperation("删除已创建课程接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="course_id",value = "课程id",dataType = "string"),
    })
    public JSONObject deleteAllCreatedCourse(@RequestBody Map map) {
        String course_id = (String)map.get("course_id");
        JSONObject result = courseService.deleteAllCreatedCourseService(course_id);
        return result;
    }
}
