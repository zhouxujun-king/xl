package com.zlzl.estate.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *用户登录参数
 */
@Setter
@Getter
public class AdminParam {

    @ApiModelProperty(value = "用户名",required = true)
    @NotEmpty(message = "用户名不允许为空")
    private String username;

    @ApiModelProperty(value = "密码",required = true)
    @NotEmpty(message = "密码不允许为空")
    private String password;

    @ApiModelProperty(value = "邮箱")
    @Email(message = "邮箱格式不正确")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String phone;

}
