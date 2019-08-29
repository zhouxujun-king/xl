package com.zlzl.estate.controller;

import com.zlzl.estate.model.Admin;
import com.zlzl.estate.model.Menu;
import com.zlzl.estate.service.MenuService;
import com.zlzl.estate.util.AdminUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 这是一个只要登录就能访问的Controller
 * 主要用来获取一些配置信息
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    MenuService menuService;
    @RequestMapping("/sysmenu")
    public List<Menu> sysmenu() {
        return menuService.getMenusByHrId();
    }

    @RequestMapping("/admin")
    public Admin currentUser() {
        return AdminUtils.getCurrentHr();
    }
}
