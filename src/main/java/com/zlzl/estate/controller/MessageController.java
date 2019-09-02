package com.zlzl.estate.controller;

import com.zlzl.estate.common.CommonResult;
import com.zlzl.estate.model.Message;
import com.zlzl.estate.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "MessageController",description = "留言管理")
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @ApiOperation("保存留言")
    @RequestMapping(value = "/saveMessage",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult saveMessage(@RequestBody Message message){
        int count = messageService.save(message);
        if(count>0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


}
