package com.zlzl.estate.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Message implements Serializable {
    private Integer id;
    private String username;
    private String phone;
    private String content;

}
