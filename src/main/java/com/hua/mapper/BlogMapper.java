package com.hua.mapper;

import com.hua.pojo.Blog;
import com.hua.pojo.query.BlogQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 博客管理持久层接口
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/27 18:12
 **/
@Mapper
@Repository
public interface BlogMapper {
    int addBlog(Blog blog);
    int delBlogById(@Param("id") Long id);
    int updateBlog(Blog blog);
    Blog getBlogById(@Param("id") Long id);
    List<Blog> getAllBlog();
    List<Blog> getAllRecommendBlog();
    List<Blog> searchBlog(String query);
    List<BlogQuery> getAllBlogQuery();
    List<BlogQuery> getBlogQueryByTitleOrTypeId(@Param("title") String title,@Param("typeId") Long typeId);
    List<Blog> getBlogsByTypeId(@Param("typeId") Long typeId);

    int updateViews(@Param("id") Long id);
    //    根据博客id查询出评论数量
    int getCommentCountById(@Param("id") Long id);

    Integer getBlogTotal();

    Integer getBlogViewTotal();

    Integer getBlogCommentTotal();

    Integer getBlogMessageTotal();
}
