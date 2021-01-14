package com.example.framework.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.mapper.SectionMapper;
import com.example.framework.pojo.Section;
import com.example.framework.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("SectionService")
public class SectionServiceImpl extends ServiceImpl<SectionMapper, Section> implements SectionService {

    @Autowired
    SectionMapper sectionMapper;

    @Override
    @Transactional
    public int addSection(String section_name, String course_id, String create_id){

        Section section = new Section();

        section.setSection_name(section_name);
        section.setCourse_id(course_id);
        section.setCreate_by(create_id);
        section.setStatus("1");

        sectionMapper.insert(section);

        return 1;
    }

    @Override
    @Transactional
    public List<Map> getSection(String course_id){

        List<Map> map = sectionMapper.textSection(course_id);

        return map;
    }

    @Override
    @Transactional
    public int updateSection(String uuid, String section_name){

        UpdateWrapper<Section> updateWrapper = new UpdateWrapper<>();

        Section section = new Section();

        section.setSection_name(section_name);

        updateWrapper.eq("uuid",uuid);

        sectionMapper.update(section, updateWrapper);

        return 1;
    }
    @Override
    @Transactional
    public int deleteSection(String uuid){
        UpdateWrapper<Section> updateWrapper = new UpdateWrapper<>();
        Section section = new Section();

        section.setStatus("0");

        updateWrapper.eq("uuid",uuid);

        sectionMapper.update(section, updateWrapper);

        return 1;
    }
}
