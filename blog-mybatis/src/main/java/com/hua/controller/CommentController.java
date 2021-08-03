package com.hua.controller;

import com.hua.pojo.Blog;
import com.hua.pojo.Comment;
import com.hua.pojo.User;
import com.hua.service.BlogService;
import com.hua.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 评论控制器
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/30 17:20
 **/
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogService blogService;
    @Value("${comment.avatar}")
    private String avatar;

    //查询评论
    @GetMapping("/comments/{id}")
    public String queryComment(@PathVariable("id") Long id, Model model){
        List<Comment> comments = commentService.listCommentByBlogId(id);
        model.addAttribute("comments", comments);
        return "blog :: commentList";
    }

    //新增评论
    @PostMapping("/comments")
    public String addComment(Comment comment, HttpSession session,Model model){
        System.out.println(comment);
        User user = (User) session.getAttribute("user");
        if(user!=null){
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        }else {
            comment.setAdminComment(false);
            comment.setAvatar(avatar);
        }
        if (comment.getParentComment()!=null){
            comment.setParentCommentId(comment.getParentComment().getId());
        }
        commentService.addComment(comment);
        return "redirect:/comments/"+comment.getBlogId();
    }

    //    删除评论
    @GetMapping("/comment/{blogId}/{id}/delete")
    public String delete(@PathVariable Long blogId, @PathVariable Long id, Model model){
        commentService.delCommentById(id);
        Blog blog = blogService.getBlogById(blogId);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("blog", blog);
        model.addAttribute("comments", comments);
        return "blog";
    }

}
