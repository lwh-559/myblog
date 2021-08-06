package com.hua.controller;

import com.hua.pojo.Message;
import com.hua.pojo.User;
import com.hua.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 留言板控制器
 *
 * @author <lwh_559@163.com>
 * @since 2021/8/4 16:40
 **/
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/message")
    public String toMessagePage(){
        return "message";
    }

    @GetMapping("/queryMessage")
    public String queryMessage(Model model){
        List<Message> messages = messageService.getAllMessage();
        model.addAttribute("messages", messages);
        return "message :: messageList";
    }

    @PostMapping("/message")
    public String addMessage(Message message, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user!=null){
            message.setAvatar(user.getAvatar());
            message.setAdminMessage(true);
        }else {
            message.setAdminMessage(false);
            message.setAvatar(avatar);
        }
        if (message.getParentMessage()!=null){
            message.setParentMessageId(message.getParentMessage().getId());
        }
        messageService.addMessage(message);
        return "redirect:/queryMessage";
    }

    @GetMapping("/message/{id}/delete")
    public String delMessage(@PathVariable("id") Long id){
        messageService.delMessageById(id);
        return "redirect:/message";
    }

}
