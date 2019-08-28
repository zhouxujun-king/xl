package com.zlzl.estate.mapper;

import com.zlzl.estate.model.Admin;

import java.util.List;

public interface AdminMapper {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    List<Admin> SelectByUsername(String username);
}
