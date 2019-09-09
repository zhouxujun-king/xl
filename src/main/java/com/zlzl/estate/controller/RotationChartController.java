package com.zlzl.estate.controller;

import com.zlzl.estate.common.CommonResult;
import com.zlzl.estate.model.RotationChart;
import com.zlzl.estate.service.RotationChartService;
import com.zlzl.estate.util.CommonPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@Api(tags = "RotationChartController",description = "轮播图后台管理")
@RequestMapping("/chart")
public class RotationChartController {
    private static final Logger LOGGER= LoggerFactory.getLogger(RotationChartController.class);

    @Autowired
    private RotationChartService rotationChartService;

    @ApiOperation("轮播图列表展示")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<RotationChart>> list(@RequestParam(value = "keyword", required = false) String keyword,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        List<RotationChart> chartlist = rotationChartService.list(keyword,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(chartlist));
    }

    @ApiOperation("添加图片")
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult addPic(@RequestBody RotationChart rotationChart){
        int count = rotationChartService.add(rotationChart);
        if(count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除图片")
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deletePic(@PathVariable Integer id){
        int count = rotationChartService.delete(id);
        if(count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation("编辑图片")
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult editPic(@PathVariable Integer id){
        int count = rotationChartService.update(id);
        if(count>0){
            CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("编辑图片")
    @RequestMapping(value = "/uploadPic",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult uploadPic(HttpServletRequest request, @RequestParam("file") MultipartFile file){
        try {
            rotationChartService.uploadFile(request, file);
        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.failed();
        }
        return CommonResult.success("success");
    }

}
