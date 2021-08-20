package com.bondsales.backend.Interceptor;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Resource
    private RedisTemplate redisTemplate;

    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
    }
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response)
            throws Exception {
    }


    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        if(session.getAttribute("username") == null){
            return false;
        } else {
            redisTemplate.opsForValue().get(session.getAttribute("username"));
            return true;
        }
    }

}
