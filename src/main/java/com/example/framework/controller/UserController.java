package com.example.framework.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.framework.service.UserService;
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
@Api(tags = "User接口")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    @ApiOperation("注册用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="user_name",value = "用户名",dataType = "string"),
            @ApiImplicitParam(name="account",value = "账号",dataType = "string"),
            @ApiImplicitParam(name="password",value = "密码",dataType = "string"),
    })
    public JSONObject addUser(@RequestBody Map map) {
        String user_name = (String) map.get("user_name");
        String account = (String) map.get("account");
        String password = (String) map.get("password");
        JSONObject result = userService.addUserService(user_name,account,password);
        return result;
    }

    @PostMapping("/Login")
    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="account",value = "账号",dataType = "string"),
            @ApiImplicitParam(name="password",value = "密码",dataType = "string"),
    })
    public JSONObject userLogin(@RequestBody Map map) {
        String account = (String) map.get("account");
        String password = (String) map.get("password");
        JSONObject result = userService.userLoginService(account,password);
        return result;
    }

    @PostMapping("/Logout")
    @ApiOperation("用户登出接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="uuid",value = "全局id",dataType = "string"),
    })
    public JSONObject userLogout(@RequestBody Map map){
        String uuid = (String)map.get("uuid");
        JSONObject result = userService.userLogout(uuid);
        return result;
    }

}
