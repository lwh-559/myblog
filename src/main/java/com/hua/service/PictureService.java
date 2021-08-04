package com.hua.service;

import com.hua.pojo.Picture;

import java.util.List;

/**
 * 照片墙业务层接口
 *
 * @author <lwh_559@163.com>
 * @since 2021/8/4 23:58
 **/
public interface PictureService {
    int addPicture(Picture picture);
    int delPictureById(Long id);
    int updatePicture(Picture picture);
    Picture getPictureById(Long id);
    List<Picture> getAllPicture();
}
