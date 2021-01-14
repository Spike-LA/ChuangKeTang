package com.example.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.framework.pojo.Exercises;

import com.example.framework.pojo.Forum;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumMapper extends BaseMapper<Forum> {
}
