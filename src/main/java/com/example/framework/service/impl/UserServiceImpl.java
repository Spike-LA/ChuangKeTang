package com.example.framework.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.framework.mapper.UserMapper;
import com.example.framework.pojo.User;
import com.example.framework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional
    public JSONObject addUserService(String user_name,String account,String password){
        JSONObject resultImpl = new JSONObject();
        User user = new User();
        user.setUser_name(user_name);
        user.setAccount(account);
        user.setPassword(password);
        user.setRole_id("e6bb794250d611ebb44a5254006e8f56");
        user.setStatus("0");
        if(userMapper.retrieveDependAccount(account).size()>0){
            resultImpl.put("executue_result","账号已存在");
        }
        else{
            resultImpl.put("execute_result","注册成功");
            userMapper.insert(user);
        }
        return resultImpl;
    }

    @Override
    @Transactional
    public JSONObject userLoginService(String account, String password){
        JSONObject resultImpl = new JSONObject();
        if (userMapper.retrieveDependAccount(account).size()==0){
            resultImpl.put("execute_result","账号不存在");
        }
        else if (userMapper.retrieveDependAccount(account).size()>0){
            for (Map userMap : userMapper.retrieveDependAccount(account)) {
                if(userMap.get("password").equals(password)){
                    resultImpl.put("execute_result","登陆成功");
                    List<User> object_list = userMapper.selectByMap(userMap);
                    User user = object_list.get(0);
                    user.setStatus("1");
                    UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
                    userUpdateWrapper.eq("uuid",(String)userMap.get("uuid"));
                    userMapper.update(user,userUpdateWrapper);
                    resultImpl.put("user",user);
                }
                else {
                    resultImpl.put("execute_result","密码错误");
                }
            }
        }
        return resultImpl;
    }

    @Override
    @Transactional
    public JSONObject userLogout(String uuid){
        JSONObject resultImpl = new JSONObject();
        List<Map> userListMap = userMapper.retrieveDependUuid(uuid);
        Map userMap = userListMap.get(0);
        List<User> object_list = userMapper.selectByMap(userMap);
        User user = object_list.get(0);
        user.setStatus("0");
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("uuid",user.getUuid());
        userMapper.update(user,userUpdateWrapper);
        resultImpl.put("execute_result","登出成功");
        return resultImpl;
    }
}
