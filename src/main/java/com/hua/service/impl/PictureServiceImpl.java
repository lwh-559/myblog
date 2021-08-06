package com.hua.service.impl;

import com.hua.mapper.PictureMapper;
import com.hua.pojo.Picture;
import com.hua.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 照片墙业务层接口实现类
 *
 * @author <lwh_559@163.com>
 * @since 2021/8/4 23:59
 **/
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public int addPicture(Picture picture) {
        return pictureMapper.addPicture(picture);
    }

    @Override
    public int delPictureById(Long id) {
        return pictureMapper.delPictureById(id);
    }

    @Override
    public int updatePicture(Picture picture) {
        return pictureMapper.updatePicture(picture);
    }

    @Override
    public Picture getPictureById(Long id) {
        return pictureMapper.getPictureById(id);
    }

    @Override
    public List<Picture> getAllPicture() {
        return pictureMapper.getAllPicture();
    }
}
