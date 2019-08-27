package com.zlzl.estate.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Admin implements Serializable {

    private Long id;

    private String username;

    private String password;

    private String email;

    private String phone;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "最后登录时间")
    private String loginTime;
}
