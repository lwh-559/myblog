package com.hua.service;

import com.hua.pojo.Message;

import java.util.List;

/**
 * 留言板业务层接口
 *
 * @author <lwh_559@163.com>
 * @since 2021/8/4 16:18
 **/
public interface MessageService {
    int addMessage(Message message);
    int delMessageById(Long id);
    List<Message> getMessageByParentMessageId(Long parentMessageId);
    List<Message> getAllMessage();
}
