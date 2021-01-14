package com.example.framework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.framework.pojo.Section;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Repository
public interface SectionService extends IService<Section> {

    int addSection(String section_name, String course_id, String create_id);

    @Transactional
    List<Map> getSection(String course_id);

    @Transactional
    int updateSection(String uuid, String section_name);

    @Transactional
    int deleteSection(String uuid);

}
