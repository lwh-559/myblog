package com.hua.controller;

import com.hua.pojo.Picture;
import com.hua.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 照片墙展示控制类
 *
 * @author <lwh_559@163.com>
 * @since 2021/8/5 16:08
 **/
@Controller
public class PictureShowController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/picture")
    public String pictureShow(Model model){
        List<Picture> pictures = pictureService.getAllPicture();
        model.addAttribute("pictures",pictures);
        return "picture";
    }
}
