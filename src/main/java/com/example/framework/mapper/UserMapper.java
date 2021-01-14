package com.example.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.framework.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {
    List<Map> retrieveDependAccount(@Param("account") String account);
    List<Map> retrieveDependUuid(@Param("uuid") String uuid);
}
