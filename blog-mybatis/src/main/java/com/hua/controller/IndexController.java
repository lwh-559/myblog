package com.hua.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hua.NotFoundException;
import com.hua.pojo.Blog;
import com.hua.pojo.Type;
import com.hua.pojo.query.BlogQuery;
import com.hua.service.BlogService;
import com.hua.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 首页控制器
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/22 16:26
 **/
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){

        //按照id升序排序
        String orderBy = "update_time desc";
        PageHelper.startPage(pageNum,10,orderBy);
        List<Blog> allBlog = blogService.getAllBlog();
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(allBlog);
        List<Blog> recommendBlogs = blogService.getAllRecommendBlog();
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("recommendBlogs",recommendBlogs);
        return "index";
    }

    @PostMapping("/search")
    public String searchBlog(String query,Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        //按照id升序排序
        String orderBy = "update_time desc";
        PageHelper.startPage(pageNum,10,orderBy);
        List<Blog> allBlog = blogService.searchBlog(query);
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(allBlog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("query",query);
        System.out.println(query);
        System.out.println("=====================");
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model){
        System.out.println(id);
        blogService.updateViews(id);
        blogService.getCommentCountById(id);
        Blog blog = blogService.getBlogById(id);
        if (blog==null){
            throw new NotFoundException("该博客不存在");
        }
        String content = blog.getContent();
        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        model.addAttribute("blog",blog);
        return "blog";
    }

    //    博客信息
    @GetMapping("/footer/blogmessage")
    public String blogMessage(Model model){
        System.out.println("博客详情=======");
        int blogTotal = blogService.getBlogTotal();
        int blogViewTotal = blogService.getBlogViewTotal();
        int blogCommentTotal = blogService.getBlogCommentTotal();
        int blogMessageTotal = blogService.getBlogMessageTotal();

        model.addAttribute("blogTotal",blogTotal);
        model.addAttribute("blogViewTotal",blogViewTotal);
        model.addAttribute("blogCommentTotal",blogCommentTotal);
        model.addAttribute("blogMessageTotal",blogMessageTotal);
        return "index :: blogMessage";
    }

    // 时间轴
    @GetMapping("/archives")
    public String archivesShow(Model model){
        List<BlogQuery> allBlogQuery = blogService.getAllBlogQuery();
        model.addAttribute("allBlogQuery",allBlogQuery);
        return "archives";
    }

    //关于我
    @GetMapping("/about")
    public String aboutMe(){
        return "about";
    }
}
