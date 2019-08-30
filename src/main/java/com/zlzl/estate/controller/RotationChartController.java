package com.zlzl.estate.controller;

import com.zlzl.estate.common.CommonResult;
import com.zlzl.estate.model.RotationChart;
import com.zlzl.estate.service.RotationChartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "RotationChartController",description = "轮播图后台管理")
@RequestMapping("/chart")
public class RotationChartController {
    private static final Logger LOGGER= LoggerFactory.getLogger(RotationChartController.class);

    @Autowired
    private RotationChartService rotationChartService;

    @ApiOperation("轮播图列表展示")
    @RequestMapping("/list")
    @ResponseBody
    public CommonResult<List<RotationChart>> list(){
        List<RotationChart> chartlist = rotationChartService.list();
        return CommonResult.success(chartlist);
    }

    @ApiOperation("添加图片")
    @RequestMapping("/add")
    @ResponseBody
    public CommonResult addPic(@RequestBody RotationChart rotationChart){
        int count = rotationChartService.add(rotationChart);
        if(count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除图片")
    @RequestMapping("/delete")
    @ResponseBody
    public CommonResult deletePic(@PathVariable Integer id){
        int count = rotationChartService.delete(id);
        if(count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation("编辑图片")
    @RequestMapping("/edit")
    @ResponseBody
    public CommonResult editPic(@PathVariable Integer id){
        int count = rotationChartService.update(id);
        if(count>0){
            CommonResult.success(count);
        }
        return CommonResult.failed();
    }

}
