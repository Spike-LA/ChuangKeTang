package com.example.framework.controller;

import com.alibaba.fastjson.JSONObject;
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
    private SectionService sectionService;

    @PostMapping("/addSection")
    @ApiOperation("添加章节接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "section_name", value = "章节名称", dataType = "string"),
            @ApiImplicitParam(name = "course_id", value = "课程id", dataType = "string"),
            @ApiImplicitParam(name = "create_by", value = "创建人id", dataType = "string"),
    })
    public JSONObject addSection(@RequestBody Map map) {
        String section_name = (String) map.get("section_name");
        String course_id = (String) map.get("course_id");
        String create_by = (String) map.get("create_by");

        JSONObject result = sectionService.addSectionService(section_name,course_id,create_by);

        return result;
    }

    @PostMapping("/getSection")
    @ApiOperation("查询章节接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course_id", value = "课程id", dataType = "string"),
    })
    public JSONObject getSection(@RequestBody Map map) {
        String course_id = (String) map.get("course_id");
        JSONObject result = sectionService.getSectionService(course_id);
        return result;
    }

    @PostMapping("/updateSection")
    @ApiOperation("修改章节接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "section_id", value = "章节id", dataType = "string"),
            @ApiImplicitParam(name = "section_name", value = "章节名称", dataType = "string"),
    })
    public JSONObject updateSection(@RequestBody Map map) {
        String section_id = (String)map.get("section_id");
        String section_name = (String)map.get("section_name");
        JSONObject result = sectionService.updateSectionService(section_id,section_name);
        return result;
    }

    @PostMapping("/deleteSection")
    @ApiOperation("删除章节接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "section_id", value = "章节id", dataType = "string"),
    })
    public JSONObject deleteSection(@RequestBody Map map) {
        String section_id = (String)map.get("section_id");
        JSONObject result = sectionService.deleteSectionService(section_id);
        return result;
    }
}
