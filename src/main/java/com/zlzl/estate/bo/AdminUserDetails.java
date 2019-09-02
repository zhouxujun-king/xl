package com.zlzl.estate.bo;

import com.zlzl.estate.model.Admin;
import com.zlzl.estate.model.AdminPermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AdminUserDetails  implements UserDetails {

    private Admin admin;
    private List<AdminPermission> permissionList;
    public AdminUserDetails(Admin admin,List<AdminPermission> permissionList) {
        this.admin = admin;
        this.permissionList = permissionList;
    }

    public AdminUserDetails(Admin admin){
        this.admin=admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
