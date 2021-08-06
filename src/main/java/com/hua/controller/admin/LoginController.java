package com.hua.controller.admin;

import com.hua.pojo.User;
import com.hua.service.UserService;
import com.hua.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * 管理员登入控制器
 *
 * @author <lwh_559@163.com>
 * @since 2021/7/25 15:20
 **/
@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserService userService;

    //跳转到登录页面
    @GetMapping()
    public String loginPage(){
        return "admin/login";
    }

    //登入验证
    @PostMapping("/login")
    public String login(String username,
                        String password,
                        RedirectAttributes attributes,
                        HttpSession session){
        User user = userService.queryUserByNameAndPwd(username, MD5Utils.code(password));
        if (user!=null) {
            user.setPassword(null);
            session.setAttribute("user",user);
            return "redirect:/admin/main";
        }
        else{
            attributes.addFlashAttribute("message","用户名和密码错误");
            return "redirect:/admin";
        }
    }

    //注销
    @GetMapping("/logout")
    public String logOut(HttpSession session){
        session.removeAttribute("user");
        return"redirect:/admin";
    }
}
