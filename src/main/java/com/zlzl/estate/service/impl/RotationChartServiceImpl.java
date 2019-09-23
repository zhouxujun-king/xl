package com.zlzl.estate.service.impl;

import com.github.pagehelper.PageHelper;
import com.zlzl.estate.mapper.RotationChartMapper;
import com.zlzl.estate.model.RotationChart;
import com.zlzl.estate.service.RotationChartService;
import com.zlzl.estate.util.Appconst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class RotationChartServiceImpl implements RotationChartService {

    @Autowired
    private RotationChartMapper rotationChartMapper;

    @Override
    public List<RotationChart> list(String keyword,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return rotationChartMapper.list();
    }

    @Override
    public int add(RotationChart rotationChart) {
        return rotationChartMapper.add(rotationChart);
    }

    @Override
    public int delete(Integer id) {
        return rotationChartMapper.delete(id);
    }

    @Override
    public int update(Integer id) {
        RotationChart rotationChart = new RotationChart();
        rotationChart.setId(id);
        return rotationChartMapper.update(rotationChart);
    }

    @Override
    public String uploadFile(HttpServletRequest request, MultipartFile file) throws IOException {
        //放到指定文件夹下
        String fileName = Appconst.uploadFile(request,file);
        /*String orderno = (String) params.get("orderno");
        //将库中orderno相同的置为无效
        rotationChartMapper.updateState(Integer.valueOf(orderno));
        //保存进数据库
        RotationChart rotationChart = new RotationChart();
        rotationChart.setName(fileName);
        rotationChart.setOriname(file.getOriginalFilename());
        rotationChart.setOrderNo(Integer.valueOf(orderno));     //前台传过来
        rotationChart.setPicUrl(Appconst.uploadPath + fileName);//图片的路径
        rotationChart.setState("1");                            //默认有效
        rotationChartMapper.add(rotationChart);*/
        return fileName;
    }
}
