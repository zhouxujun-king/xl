package com.zlzl.estate.mapper;

import com.zlzl.estate.model.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    Admin SelectByUsername(String username);

    int updatePassword(Admin admin);

}
