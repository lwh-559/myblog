package com.hua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 照片墙实体类
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/25 12:40
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Picture {
    private Long id;
    private String pictureaddress;//地址
    private String picturedescription;//描述
    private String picturename;//名字
    private String picturetime;//时间地点
}
