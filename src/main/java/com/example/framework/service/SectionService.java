package com.example.framework.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.framework.pojo.Section;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface SectionService extends IService<Section> {
    JSONObject addSectionService(String section_name,String course_id,String create_by);
    JSONObject getSectionService(String course_id);
    JSONObject updateSectionService(String section_id, String section_name);
    JSONObject deleteSectionService(String section_id);
}
