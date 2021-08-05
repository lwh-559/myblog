package com.hua.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hua.pojo.Picture;
import com.hua.pojo.Type;
import com.hua.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * 照片墙管理控制器
 *
 * @author <lwh_559@163.com>
 * @since 2021/8/5 10:59
 **/
@Controller
@RequestMapping("/admin")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/pictures")
    public String allPictures(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        //排序按照id升序
        String orderBy = "id desc";
        PageHelper.startPage(pageNum,10,orderBy);
        List<Picture> list = pictureService.getAllPicture();
        PageInfo<Picture> pageInfo = new PageInfo<Picture>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/pictures";
    }
    //跳转到新增页
    @GetMapping("/pictures/input")
    public String toAddPicturesPage(Model model){
        Picture picture = new Picture();
        model.addAttribute("picture",picture);
        return "admin/pictures-input";
    }

    //执行新增
    @PostMapping("/pictures")
    public String addPicture(@Valid Picture picture, BindingResult result, RedirectAttributes attributes){

        if(result.hasErrors()){
            return "admin/pictures-input";
        }

        int i = pictureService.addPicture(picture);
        if (i==1){
            attributes.addFlashAttribute("message","新增成功");
        }else {
            attributes.addFlashAttribute("message","新增失败");
        }
        return "redirect:/admin/pictures";
    }

    //跳转到编辑页
    @GetMapping("/pictures/{id}/input")
    public String toEditPicturePage(@PathVariable("id") Long id,Model model){
        Picture picture = pictureService.getPictureById(id);
        model.addAttribute("picture",picture);
        return "admin/pictures-input";
    }

    @PostMapping("/pictures/update")
    public String updatePicture(@Valid Picture picture,RedirectAttributes attributes){
        int i = pictureService.updatePicture(picture);
        if (i==1){
            attributes.addFlashAttribute("message","更新成功");
        }else {
            attributes.addFlashAttribute("message","更新失败");
        }
        return "redirect:/admin/pictures";
    }

    @GetMapping("/pictures/{id}/del")
    public String delPicture(@PathVariable("id") Long id,RedirectAttributes attributes){
        int i = pictureService.delPictureById(id);
        if (i==1){
            attributes.addFlashAttribute("message","删除成功");
        }else{
            attributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/admin/pictures";
    }
}
