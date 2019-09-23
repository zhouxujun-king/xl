package com.zlzl.estate.service;

import com.zlzl.estate.model.RotationChart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface RotationChartService {

    /**
     * 轮播图列表
     */
    List<RotationChart> list(String keyword,Integer pageNum,Integer pageSize);

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

    /**
     * 上传文件
     * @param request
     * @param file
     * @param params
     */
    String uploadFile(HttpServletRequest request, MultipartFile file) throws IOException;
}
