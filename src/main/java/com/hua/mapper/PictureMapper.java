package com.hua.mapper;

import com.hua.pojo.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 照片墙持久层接口
 *
 * @author <lwh_559@163.com>
 * @since 2021/8/4 23:40
 **/
@Mapper
@Repository
public interface PictureMapper {
    int addPicture(Picture picture);
    int delPictureById(@Param("id") Long id);
    int updatePicture(Picture picture);
    Picture getPictureById(@Param("id") Long id);
    List<Picture> getAllPicture();
}
