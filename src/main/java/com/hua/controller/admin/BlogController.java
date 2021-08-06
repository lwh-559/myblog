package com.hua.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hua.pojo.Blog;
import com.hua.pojo.Type;
import com.hua.pojo.User;
import com.hua.pojo.query.BlogQuery;
import com.hua.service.BlogService;
import com.hua.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 博客管理控制器
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/27 17:21
 **/
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;

    //显示博客列表
    @GetMapping("/blogs")
    public String blogs(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        //按照更新时间 倒序排序
        String orderBy= "update_time desc";
        PageHelper.startPage(pageNum,10,orderBy);
        List<BlogQuery> list = blogService.getAllBlogQuery();
        PageInfo<BlogQuery> pageInfo = new PageInfo<BlogQuery>(list);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("types",typeService.getTypeAll());
        return "admin/blogs";
    }
    //搜索博客
    @PostMapping("/blogs/search")
    private String search(String title, Long typeId, Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, RedirectAttributes attributes){
        //按照更新时间 倒序排序
        String orderBy= "update_time desc";
        PageHelper.startPage(pageNum,10,orderBy);
        List<BlogQuery> list = blogService.getBlogQueryByTitleOrTypeId(title,typeId);
        PageInfo<BlogQuery> pageInfo = new PageInfo<BlogQuery>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs :: blogList";
    }
    //跳转到博客新增页
    @GetMapping("/blogs/input")
    public String toAddBlogPage(Model model){
        model.addAttribute("types",typeService.getTypeAll());
        model.addAttribute("blog",new Blog());
        return "admin/blogs-input";
    }
    //新增博客
    @PostMapping("/blogs")
    public String addBlog(Blog blog, Model model, RedirectAttributes attributes, HttpSession session){
        User user = (User) session.getAttribute("user");
        blog.setUser(user);//设置作者
        blog.setType(typeService.getTypeById(blog.getTypeId()));//设置类型
        blog.setUserId(user.getId());
        int i = blogService.addBlog(blog);
        if (i==1){
            attributes.addFlashAttribute("message","新增成功");
        }else {
            attributes.addFlashAttribute("message","新增失败");
        }
        System.out.println(blog);
        return "redirect:/admin/blogs";
    }
    //跳转到博客编辑页
    @GetMapping("/blogs/{id}/input")
    public String toUpdateBlogPage(@PathVariable Long id, Model model){
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("types",typeService.getTypeAll());
        model.addAttribute("blog",blog);
        return "admin/blogs-input";
    }
    //更新博客
    @PostMapping("/blogs/update")
    public String toUpdateBlogPage(Blog blog, Model model,RedirectAttributes attributes){
        int i = blogService.updateBlog(blog);
        if (i==1){
            attributes.addFlashAttribute("message","修改成功");
        }else {
            attributes.addFlashAttribute("message","修改失败");
        }
        return "redirect:/admin/blogs";
    }
    //删除博客
    @GetMapping("/blogs/{id}/del")
    public String delBlog(@PathVariable Long id,RedirectAttributes attributes){
        int i = blogService.delBlogById(id);
        if (i==1){
            attributes.addFlashAttribute("message","删除成功");
        }else {
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/admin/blogs";
    }

}
