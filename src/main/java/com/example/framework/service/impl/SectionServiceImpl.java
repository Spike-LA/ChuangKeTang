package com.example.framework.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.mapper.SectionMapper;
import com.example.framework.pojo.Section;
import com.example.framework.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("SectionService")
public class SectionServiceImpl extends ServiceImpl<SectionMapper, Section> implements SectionService {

    @Autowired
    SectionMapper sectionMapper;

    @Override
    @Transactional
    public JSONObject addSectionService(String section_name, String course_id, String create_by){
        JSONObject resultImpl = new JSONObject();
        Section section = new Section();

        section.setSection_name(section_name);
        section.setCourse_id(course_id);
        section.setCreate_by(create_by);
        section.setStatus("1");

        sectionMapper.insert(section);

        resultImpl.put("execute_result", "添加成功");

        return resultImpl;
    }

    @Override
    @Transactional
    public JSONObject getSectionService(String course_id){
        JSONObject resultImpl = new JSONObject();
        sectionMapper.textSection(course_id);

        resultImpl.put("result",sectionMapper.textSection(course_id));

        return resultImpl;
    }

    @Override
    @Transactional
    public JSONObject updateSectionService(String section_id, String section_name){
        JSONObject resultImpl = new JSONObject();
        UpdateWrapper<Section> sectionUpdateWrapper = new UpdateWrapper<>();
        sectionUpdateWrapper.eq("uuid",section_id);
        Section section = sectionMapper.selectOne(sectionUpdateWrapper);
        section.setSection_name(section_name);
        int update = sectionMapper.update(section,sectionUpdateWrapper);
        if (update==1){
            resultImpl.put("execute_result","修改成功");
        }else{
            resultImpl.put("execute_result","修改失败");
        }

        return resultImpl;
    }

    @Override
    @Transactional
    public JSONObject deleteSectionService(String section_id){
        JSONObject resultImpl = new JSONObject();
        UpdateWrapper<Section> sectionUpdateWrapper = new UpdateWrapper<>();
        sectionUpdateWrapper.eq("uuid",section_id);
        Section section = sectionMapper.selectOne(sectionUpdateWrapper);
        section.setStatus("0");
        int update = sectionMapper.update(section,sectionUpdateWrapper);
        if (update==1){
            resultImpl.put("execute_result","删除成功");
        }else{
            resultImpl.put("execute_result","删除失败");
        }

        return resultImpl;
    }
}
