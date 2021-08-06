package com.hua.service.impl;

import com.hua.mapper.MessageMapper;
import com.hua.pojo.Comment;
import com.hua.pojo.Message;
import com.hua.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 留言板业务层接口实现类
 *
 * @author <lwh_559@163.com>
 * @since 2021/8/4 16:19
 **/
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    //存放迭代找出的所有子代的集合
    private List<Message> tempReplys = new ArrayList<>();

    @Override
    public int addMessage(Message message) {
        message.setCreateTime(new Date());
        return messageMapper.addMessage(message);
    }

    @Override
    public int delMessageById(Long id) {
        return messageMapper.delMessageById(id);
    }

    @Override
    public List<Message> getMessageByParentMessageId(Long parentMessageId) {
        return messageMapper.getMessageByParentMessageId(parentMessageId);
    }

    @Override
    public List<Message> getAllMessage() {
        //查询出父节点
        List<Message> messages = messageMapper.getMessageByParentMessageId(Long.parseLong("-1"));
        for(Message message : messages){
            Long id = message.getId();
            String parentNickname1 = message.getNickname();
            List<Message> childMessages = messageMapper.getMessageByParentMessageId(id);
//            查询出子评论
            combineChildren(childMessages, parentNickname1);
            message.setReplyMessages(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return messages;
    }

    private void combineChildren(List<Message> childMessages, String parentNickname1) {
//        判断是否有一级子评论
        if(childMessages.size() > 0){
//                循环找出子评论的id
            for(Message childMessage : childMessages){
                String parentNickname = childMessage.getNickname();
                childMessage.setParentNickname(parentNickname1);
                tempReplys.add(childMessage);
                Long childId = childMessage.getId();
//                    查询出子二级评论
                recursively(childId, parentNickname);
            }
        }
    }

    private void recursively(Long childId, String parentNickname1) {
//        根据子一级评论的id找到子二级评论
        List<Message> replayMessages = messageMapper.getMessageByParentMessageId(childId);

        if(replayMessages.size() > 0){
            for(Message replayMessage : replayMessages){
                String parentNickname = replayMessage.getNickname();
                replayMessage.setParentNickname(parentNickname1);
                Long replayId = replayMessage.getId();
                tempReplys.add(replayMessage);
                recursively(replayId,parentNickname);
            }
        }
    }

}
