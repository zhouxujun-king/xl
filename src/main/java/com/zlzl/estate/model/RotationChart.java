package com.zlzl.estate.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class RotationChart implements Serializable {

    private Integer id;

    private Integer orderNo;

    private String picUrl;
}
