package com.zlzl.estate.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(tags = "AdminController",description = "后台用户管理")
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
