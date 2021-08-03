package com.hua.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hua.pojo.Type;
import com.hua.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * 分类控制器
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/26 10:11
 **/
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String allTypes(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        //排序按照id升序
        String orderBy = "id asc";
        PageHelper.startPage(pageNum,10,orderBy);
        List<Type> list = typeService.getTypeAll();
        PageInfo<Type> pageInfo = new PageInfo<Type>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/types";
    }

    //跳转到新增页
    @GetMapping("/types/input")
    public String toAddPage(Model model){
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }
    //执行新增
    @PostMapping("/types")
    public String add(@Valid Type type, RedirectAttributes attributes){
        Type name = typeService.getTypeByName(type.getName());
        if (name!=null){
            attributes.addFlashAttribute("message","不能添加重复的分类");
            return "redirect:/admin/types/input";
        }
        Integer i = typeService.addType(type);
        if (i==1){
            attributes.addFlashAttribute("message","新增成功");
        }else {
            attributes.addFlashAttribute("message","新增失败");
        }
        return "redirect:/admin/types";
    }


    //跳转到编辑页
    @GetMapping("/types/{id}/input")
    public String toEditPage(@PathVariable Long id,Model model){
        Type type = typeService.getTypeById(id);
        model.addAttribute("type",type);
        return "admin/types-input";
    }

    //执行更新
    @PostMapping("/types/update")
    public String update(@Valid Type type,RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1!=null){
            attributes.addFlashAttribute("message","不能添加重复的分类");
            return "redirect:/admin/types/input";
        }
        Integer i = typeService.updateType(type);
        if (i==1){
            attributes.addFlashAttribute("message","更新成功");
        }else {
            attributes.addFlashAttribute("message","更新失败");
        }
        return "redirect:/admin/types";
    }

    //删除分类
    @GetMapping("/types/{id}/del")
    public String del(@PathVariable Long id,RedirectAttributes attributes){
        Integer i = typeService.delTypeById(id);
        if (i==1){
            attributes.addFlashAttribute("message","删除成功");
        }else{
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/admin/types";
    }

}
