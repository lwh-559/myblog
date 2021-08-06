package com.hua;

import com.hua.pojo.Blog;
import com.hua.pojo.Type;
import com.hua.pojo.User;
import com.hua.pojo.query.BlogQuery;
import com.hua.service.BlogService;
import com.hua.service.TypeService;
import com.hua.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogMybatisApplicationTests {
    @Autowired
    private UserService userService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @Test
    void contextLoads() {
//        List<Blog> allBlog = blogService.getAllRecommendBlog();
//        for (Blog blog : allBlog) {
//            System.out.println(blog);
//        }
        System.out.println("====================================");
        List<BlogQuery> allBlogQuery = blogService.getAllBlogQuery();
        for (BlogQuery blogQuery : allBlogQuery) {
            System.out.println(blogQuery);
        }
    }

    @Test
    void contextLoads2() {
//        //增
//        typeService.addType(new Type(1002L,"Mybatis",null));
//        typeService.addType(new Type(1003L,"Spring",null));
//        typeService.addType(new Type(1004L,"springMVC",null));
//        typeService.addType(new Type(1005L,"Mybatis",null));
//        //查
        List<Type> typeAll = typeService.getTypeAll();
        for (Type type : typeAll) {
            System.out.println(type);
        }
//        Type typeById = typeService.getTypeById(1005L);
//        System.out.println(typeById);
//        System.out.println(typeService.getTypeByName("Mybatis"));
//        System.out.println(typeService.getTypeByName("123"));
//        //改
//        System.out.println(typeService.updateType(new Type(1001L, "SpringCloud", null)));
//        //删
//        System.out.println(typeService.delTypeById(1005L));
    }


}
