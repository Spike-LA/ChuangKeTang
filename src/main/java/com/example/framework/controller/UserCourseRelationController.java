package com.example.framework.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.framework.service.UserCourseRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "用户课程操作接口")
public class UserCourseRelationController {

    @Autowired
    private UserCourseRelationService userCourseRelationService;

    @PostMapping("/userRetrieveCourse")
    @ApiOperation("用户选课接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_name", value = "用户名", dataType = "string"),
            @ApiImplicitParam(name = "course_name", value = "课程名", dataType = "string"),
    })
    public List<Map> retrieveCourse(@RequestBody Map map){
        String user_name = (String)map.get("user_name");
        String course_name = (String)map.get("course_name");
        List<Map> retrieveCourseList= userCourseRelationService.retrieveCourseService(user_name,course_name);
        return retrieveCourseList;
    }

    @PostMapping("/userSelectCourse")
    @ApiOperation("用户选课接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户id", dataType = "string"),
            @ApiImplicitParam(name = "course_id", value = "课程id", dataType = "string"),
    })
    public JSONObject selectCourse(@RequestBody Map map){
        String user_id = (String)map.get("user_id");
        String course_id = (String)map.get("course_id");
        JSONObject result = userCourseRelationService.selectCourseService(user_id,course_id);
        return result;
    }

    @PostMapping("/userRetrieveSelectedCourse")
    @ApiOperation("用户查看已选课程接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id",value = "用户id",dataType = "string")
    })
    public List<Map> retrieveSelectedCourse(@RequestBody Map map){
        String user_id = (String)map.get("user_id");
        List<Map> selectedCourseList =userCourseRelationService.retrieveSelectedCourseService(user_id);
        return selectedCourseList;
    }

    @PostMapping("/userDeleteCourse")
    @ApiOperation("用户退选课程接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户id", dataType = "string"),
            @ApiImplicitParam(name = "course_id", value = "课程id", dataType = "string"),
    })
    public JSONObject deleteCourse(@RequestBody Map map){
        String user_id = (String)map.get("user_id");
        String course_id = (String)map.get("course_id");
        JSONObject result = userCourseRelationService.deleteCourseService(user_id,course_id);
        return result;
    }

    @PostMapping("/userRetrieveAimedSelectedCourse")
    @ApiOperation("用户搜索指定已选课程接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id",value = "用户id",dataType = "string"),
            @ApiImplicitParam(name = "course_name",value = "课程名称",dataType = "string")
    })
    public List<Map> RetrieveAimedSelectedCourse(@RequestBody Map map){
        String user_id = (String)map.get("user_id");
        String course_name = (String)map.get("course_name");
        List<Map> aimedSelectedCourseList = userCourseRelationService.retrieveAimedSelectedCourseService(user_id,course_name);
        return aimedSelectedCourseList;
    }


}
