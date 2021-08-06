package com.hua.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hua.pojo.Blog;
import com.hua.pojo.Type;
import com.hua.service.BlogService;
import com.hua.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 分类展示控制器
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/31 10:20
 **/
@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String typesShow(@PathVariable("id") Long id,Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        List<Type> types = typeService.getTypeAll();
        if(id == -1){
            id = types.get(0).getId();
        }
        //按照update_time升序排序
        String orderBy = "update_time desc";
        PageHelper.startPage(pageNum,10,orderBy);
        List<Blog> blogsByType = blogService.getBlogsByTypeId(id);
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogsByType);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("types",types);
        model.addAttribute("activeTypeId", id);
        return "types";
    }

}
