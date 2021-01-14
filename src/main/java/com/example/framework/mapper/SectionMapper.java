package com.example.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.framework.pojo.Section;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SectionMapper extends BaseMapper<Section> {
    List<Map> textSection(@Param("course_id") String course_id);
    List<Map> textSection1(@Param("uuid") String uuid);
}
