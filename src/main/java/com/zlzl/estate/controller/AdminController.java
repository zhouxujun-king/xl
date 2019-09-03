package com.zlzl.estate.controller;


import com.zlzl.estate.common.CommonResult;
import com.zlzl.estate.dto.AdminParam;
import com.zlzl.estate.model.Admin;
import com.zlzl.estate.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @ApiOperation("登录入口")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody AdminParam adminParam,BindingResult result){
        String token=adminService.login(adminParam.getUsername(),adminParam.getPassword());
        if(token==null){
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return CommonResult.success(tokenMap);
    }



    @ApiOperation("获取登录用户信息")
    @RequestMapping("/info")
    @ResponseBody
    public CommonResult getAdminInfo( Principal principal){
        String username = principal.getName();
        Admin admin = adminService.SelectByUsername(username);
        HashMap<String, Object> data = new HashMap<>();
        data.put("username",admin.getUsername());
        data.put("roles",new String[]{"TEST"});
        return CommonResult.success(data);
    }


}
