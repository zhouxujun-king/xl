package com.zlzl.estate.service;

import com.zlzl.estate.dto.AdminParam;
import com.zlzl.estate.model.Admin;

public interface AdminService {

    /**
     * 注册
     */
    Admin register(AdminParam adminParam);

    /**
     * 登录功能
     * @param username 登录名
     * @param password 密码
     * @@return  用于生成jwt的token
     */
    String login(String username,String password);

}
