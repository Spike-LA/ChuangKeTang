package com.example.framework.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.framework.mapper.SectionMapper;
import com.example.framework.pojo.Section;
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
@Api(tags = "Section接口")
public class SectionController {

    @Autowired
    SectionService sectionService;
//
//    @Autowired
//    private SectionMapper sectionMapper;

    @PostMapping("/addSection")
    @ApiOperation("添加章节接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "section_name", value = "章节名称", dataType = "string"),
            @ApiImplicitParam(name = "course_id", value = "课程id", dataType = "string"),
            @ApiImplicitParam(name = "create_by", value = "创建人id", dataType = "string"),
    })
    public JSONObject addSection(@RequestBody Map map) {

        JSONObject result = new JSONObject();

        String section_name = (String) map.get("section_name");
        String course_id = (String) map.get("course_id");
        String create_id = (String) map.get("create_by");

//        Section section = new Section();
//
//        section.setSection_name(section_name);
//        section.setCourse_id(course_id);
//        section.setCreate_by(create_id);
//        section.setStatus("1");
//
//        int i = sectionService.addSection(section);
//        if (i==1){
//            result.put("status", "创建成功");
//        } else {
//            result.put("status", "创建失败");
//        }
//        return result;
        int i = sectionService.addSection(section_name,course_id,create_id);
        if (i==1){
            result.put("status", "创建成功");
        } else {
            result.put("status", "创建失败");
        }
        return result;
    }


    @PostMapping("/getSection")
    @ApiOperation("查询章节接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course_id", value = "课程id", dataType = "string"),
    })
    public JSONObject getSection(@RequestBody Map map){
        JSONObject result = new JSONObject();

        String course_id = (String) map.get("course_id");

        result.put("result", sectionService.getSection(course_id));

        return result;
    }
    @PostMapping("/updateSection")
    @ApiOperation("修改章节接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "section_name", value = "章节名称", dataType = "string"),
            @ApiImplicitParam(name = "uuid", value = "章节id", dataType = "string"),
    })
    public JSONObject updateSection(@RequestBody Map map) {
        JSONObject result = new JSONObject();

        String section_name = (String) map.get("section_name");
        String uuid = (String) map.get("uuid");
        int i = sectionService.updateSection(uuid,section_name);
        if (i==1){
            result.put("status", "更新成功");
        } else {
            result.put("status", "更新失败");
        }
        return result;
    }
    @PostMapping("/deleteSection")
    @ApiOperation("删除章节接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uuid", value = "章节id", dataType = "string"),
    })
    public JSONObject deleteSection(@RequestBody Map map) {
        JSONObject result = new JSONObject();
        String uuid = (String) map.get("uuid");
        int i = sectionService.deleteSection(uuid);
        if (i==1){
            result.put("status", "删除成功");
        } else {
            result.put("status", "删除失败");
        }
        return result;
    }
}
