package com.bondsales.backend.controller;

import com.bondsales.backend.Interceptor.ConstantUtils;
import com.bondsales.backend.Interceptor.WebSecurityConfig;
import com.bondsales.backend.common.UserInfo;
import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.dao.mapper.UserMapper;
import com.bondsales.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;



@RestController
public class UserController {

    @Autowired
    private UserService userservice;
    @Resource
    private UserMapper userMapper;

    @RequestMapping("/ListUser")
    @ResponseBody
    public String ListUser(){
        return userservice.ListUser();
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String delete(Long id) {
        int result = userservice.delete(id);
        if (result < 1) {
            return "删除失败";
        } else {
            return "删除成功";
        }
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String update(User user) {
        int result = userservice.Update(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public boolean insert(User user) {
        return userservice.insertUser(user);
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request, String logname, String password){
        UserInfo userInfo = new UserInfo();
        userInfo.setLogname(request.getParameter("logname"));
        userInfo.setPassword(request.getParameter("password"));



        boolean verify = userservice.login(userInfo.getLogname(), userInfo.getPassword());
        System.out.println(verify);

        if(!verify) {
            request.getSession().setAttribute(ConstantUtils.SESSION_KEY, userInfo);//username & password 都一致，设定session
            return "redirect:/login";
        }
        return "login";

    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request, String username, String password){
        request.getSession().invalidate();//使Session变成无效，及用户退出
        request.getSession().removeAttribute(ConstantUtils.SESSION_KEY);
        return "logout";
    }

}
