package com.zlzl.estate.service;

import com.zlzl.estate.model.RotationChart;

import java.util.List;

public interface RotationChartService {

    /**
     * 轮播图列表
     */
    List<RotationChart> list();

    /**
     * 添加轮播图
     */
    int add(RotationChart rotationChart);

    /**
     * 删除
     */
    int delete(Integer id);

    /**
     * 编辑
     */
    int update(Integer id);
}
