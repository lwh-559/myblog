package com.hua.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/25 17:43
 **/
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("user") == null){
            request.setAttribute("message","没有权限，请先登录");
            response.sendRedirect("/admin");
            return false;
        }
        else {
            return true;
        }
    }
}
