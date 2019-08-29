package com.zlzl.estate.config;

import com.zlzl.estate.bo.AdminUserDetails;
import com.zlzl.estate.component.RestAuthenticationEntryPoint;
import com.zlzl.estate.component.RestfulAccessDeniedHandler;
import com.zlzl.estate.mapper.AdminMapper;
import com.zlzl.estate.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;


/**
 * SpringSecurity的配置
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//配置权限
//                .antMatchers("/").access("hasRole('TEST')")//该路径需要TEST角色
                .antMatchers("/").authenticated()//该路径需要登录认证
//                .antMatchers("/brand/list").hasAuthority("TEST")//该路径需要TEST权限
                .antMatchers("/**").permitAll()
                .and()//启用基于http的认证
                .httpBasic()
                .realmName("/")
                .and()//配置登录页面
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .and()//配置退出路径
                .logout()
                .logoutSuccessUrl("/")
//                .and()//记住密码功能
//                .rememberMe()
//                .tokenValiditySeconds(60*60*24)
//                .key("rememberMeKey")
                .and()//关闭跨域伪造
                .csrf()
                .disable()
                .headers()//去除X-Frame-Options
                .frameOptions()
                .disable();
    }

//    @Bean
//    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
//        return new JwtAuthenticationTokenFilter();
//    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService(){
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Admin admin = new Admin();
                admin.setUsername(username);
                List<Admin> userAdmin = adminMapper.SelectByUsername(username);
                if(userAdmin!=null && userAdmin.size()>0){
                    return new AdminUserDetails(userAdmin.get(0));
                }
                throw new UsernameNotFoundException("用户名或密码错误");
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
