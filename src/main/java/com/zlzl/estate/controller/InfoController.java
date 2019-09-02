package com.zlzl.estate.controller;

import com.zlzl.estate.common.CommonResult;
import com.zlzl.estate.model.Admin;
import com.zlzl.estate.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "InfoController",description = "密码修改")
@RestController
@RequestMapping("/info")
public class InfoController {

    private static final Logger LOGGER= LoggerFactory.getLogger(InfoController.class);

    @Autowired
    private AdminService adminService;

    @ApiOperation("密码修改")
    @RequestMapping(value = "/updatePassword",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updatePassword(@RequestBody  String oldPassword,String newPassword){
        Admin admin = new Admin();
        //从登录状态中获取当前登录的用户
        //暂时写死了，登录接口调通后从登录接口获取
        String username="admin";
        admin.setUsername(username);
        //校验原密码
        Admin adminInfo = adminService.SelectByUsername(username);
        if(adminInfo.getPassword().equals("oldPassword")){
            try {
                admin.setPassword(newPassword);
                int count = adminService.updatePassword(admin);
                if(count>0){
                    return CommonResult.success(count);
                }
                return CommonResult.failed();
            } catch (Exception e) {
                LOGGER.error("原密码错误：{}",e.getMessage());
            }
        }
        return  CommonResult.failed();
    }

}
