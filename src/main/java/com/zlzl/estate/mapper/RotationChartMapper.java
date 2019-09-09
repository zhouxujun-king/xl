package com.zlzl.estate.mapper;

import com.zlzl.estate.model.RotationChart;
import com.zlzl.estate.util.CommonPage;
import io.swagger.models.auth.In;

import java.util.List;

public interface RotationChartMapper {

    List<RotationChart> list();

    int add(RotationChart rotationChart);

    int delete(Integer id);

    int update(RotationChart rotationChart);
}
