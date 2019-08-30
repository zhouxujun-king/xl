package com.zlzl.estate.service.impl;

import com.zlzl.estate.mapper.RotationChartMapper;
import com.zlzl.estate.model.RotationChart;
import com.zlzl.estate.service.RotationChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotationChartServiceImpl implements RotationChartService {

    @Autowired
    private RotationChartMapper rotationChartMapper;

    @Override
    public List<RotationChart> list() {
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
}
