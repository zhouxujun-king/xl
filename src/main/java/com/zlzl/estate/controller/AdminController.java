package com.zlzl.estate.controller;


import com.zlzl.estate.common.CommonResult;
import com.zlzl.estate.dto.AdminParam;
import com.zlzl.estate.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "AdminController",description = "后台用户管理")
@RequestMapping("/admin")
public class AdminController {

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private AdminService adminService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @ApiOperation("登录入口")
    @RequestMapping("/login")
    @ResponseBody
    public CommonResult login(AdminParam adminParam){
        String token=adminService.login(adminParam.getUsername(),adminParam.getPassword());
        if(token==null){
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHeader",tokenHead);
        return CommonResult.success(tokenMap);
    }

}
