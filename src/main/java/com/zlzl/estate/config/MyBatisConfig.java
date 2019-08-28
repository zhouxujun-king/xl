package com.zlzl.estate.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"com.zlzl.estate.mapper","com.zlzl.estate.dao"})
public class MyBatisConfig {
}