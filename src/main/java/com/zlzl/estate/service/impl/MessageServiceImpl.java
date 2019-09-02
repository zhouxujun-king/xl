package com.zlzl.estate.service.impl;

import com.zlzl.estate.mapper.MessageMapper;
import com.zlzl.estate.model.Message;
import com.zlzl.estate.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;
    @Override
    public int save(Message message) {
        return messageMapper.save(message);
    }
}
