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
     */
    String login(String username,String password);


}
