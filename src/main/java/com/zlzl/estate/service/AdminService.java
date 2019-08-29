package com.zlzl.estate.service;

import com.zlzl.estate.mapper.AdminMapper;
import com.zlzl.estate.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sang on 2017/12/28.
 */
@Service
@Transactional
public class AdminService implements UserDetailsService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Admin admin = adminMapper.loadUserByUsername(s);
        if (admin == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return admin;
    }

}