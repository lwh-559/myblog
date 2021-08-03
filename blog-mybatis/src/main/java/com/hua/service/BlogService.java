package com.hua.service;

import com.hua.pojo.Blog;
import com.hua.pojo.query.BlogQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 博客管理业务层
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/27 18:23
 **/
public interface BlogService {
    int addBlog(Blog blog);
    int delBlogById(Long id);
    int updateBlog(Blog blog);
    Blog getBlogById(Long id);
    List<Blog> getAllBlog();
    List<Blog> getAllRecommendBlog();
    List<Blog> searchBlog(String query);
    List<BlogQuery> getAllBlogQuery();
    List<BlogQuery> getBlogQueryByTitleOrTypeId(String title,Long typeId);
    List<Blog> getBlogsByTypeId(@Param("typeId") Long typeId);

    int updateViews(Long id);
    //    根据博客id查询出评论数量
    int getCommentCountById(Long id);

    Integer getBlogTotal();

    Integer getBlogViewTotal();

    Integer getBlogCommentTotal();

    Integer getBlogMessageTotal();
}
