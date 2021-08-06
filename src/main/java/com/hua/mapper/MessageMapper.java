package com.hua.mapper;

import com.hua.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 留言板持久层接口
 *
 * @author <lwh_559@163.com>
 * @since 2021/8/4 16:04
 **/
@Mapper
@Repository
public interface MessageMapper {
    int addMessage(Message message);
    int delMessageById(@Param("id") Long id);
    List<Message> getMessageByParentMessageId(@Param("parentMessageId") Long parentMessageId);
}
