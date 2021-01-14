package com.example.framework.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.framework.pojo.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Service
@Repository
public interface UserService extends IService<User> {
    JSONObject addUserService(String user_name,String account,String password);
    JSONObject userLoginService(String account, String password);
    JSONObject userLogout(String uuid);
}
