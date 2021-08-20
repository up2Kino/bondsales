package com.bondsales.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RequestMapping
@RestController

public class UserController {

    /**
     * 这里为了能简单在浏览器响应，暂时使用GET请求，
     *
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session) {
//        if(session.getId() == redisTemplate.opsForValue().get());
    return "已经到后端啦";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();//使Session变成无效，及用户退出
        return "logout";
    }
}
