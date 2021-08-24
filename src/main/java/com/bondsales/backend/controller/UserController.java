package com.bondsales.backend.controller;

import com.bondsales.backend.Interceptor.ConstantUtils;
import com.bondsales.backend.common.UserInfo;
import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class UserController {
    @Autowired
    private UserService userservice;

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

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestBody UserInfo userInfo){
        if(userInfo.getLogname()==null||userInfo.getPassword()==null){
            return new Gson().toJson(null);
        }

        //验证用户名和密码
        boolean verify = userservice.login(userInfo.getLogname(), userInfo.getPassword());

        if(!verify) {
            return new Gson().toJson(null);
        }
        request.getSession().setAttribute(ConstantUtils.SESSION_KEY, userInfo.getLogname());//username & password 都一致，设定session
        return new Gson().toJson(userInfo.getLogname());

    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public String logout(HttpServletRequest request, String username, String password){
        request.getSession().removeAttribute(ConstantUtils.SESSION_KEY);
        request.getSession().invalidate();//使Session变成无效，及用户退出
        return "logout";
    }

}
