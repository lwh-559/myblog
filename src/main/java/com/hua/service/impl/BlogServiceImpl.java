package com.hua.service.impl;

import com.hua.mapper.BlogMapper;
import com.hua.pojo.Blog;
import com.hua.pojo.query.BlogQuery;
import com.hua.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 博客管理业务层实现类
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/27 18:24
 **/
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public int addBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogMapper.addBlog(blog);
    }

    @Override
    public int delBlogById(Long id) {
        return blogMapper.delBlogById(id);
    }

    @Override
    public int updateBlog(Blog blog) {
        blog.setUpdateTime(new Date());
        return blogMapper.updateBlog(blog);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogMapper.getBlogById(id);
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogMapper.getAllBlog();
    }

    @Override
    public List<Blog> getAllRecommendBlog() {
        return blogMapper.getAllRecommendBlog();
    }

    @Override
    public List<Blog> searchBlog(String query) {
        return blogMapper.searchBlog(query);
    }

    @Override
    public List<BlogQuery> getAllBlogQuery() {
        return blogMapper.getAllBlogQuery();
    }

    @Override
    public List<BlogQuery> getBlogQueryByTitleOrTypeId(String title, Long typeId) {
        return blogMapper.getBlogQueryByTitleOrTypeId(title,typeId);
    }

    @Override
    public List<Blog> getBlogsByTypeId(Long typeId) {
        return blogMapper.getBlogsByTypeId(typeId);
    }

    @Override
    public int updateViews(Long id) {
        return blogMapper.updateViews(id);
    }

    @Override
    public int getCommentCountById(Long id) {
        return blogMapper.getCommentCountById(id);
    }

    @Override
    public Integer getBlogTotal() {
        return blogMapper.getBlogTotal();
    }

    @Override
    public Integer getBlogViewTotal() {
        return blogMapper.getBlogViewTotal();
    }

    @Override
    public Integer getBlogCommentTotal() {
        return blogMapper.getBlogCommentTotal();
    }

    @Override
    public Integer getBlogMessageTotal() {
        return blogMapper.getBlogMessageTotal();
    }
}
