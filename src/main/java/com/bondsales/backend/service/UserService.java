package com.bondsales.backend.service;

import com.bondsales.backend.dao.entity.Result;
import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.RedisClientInfo;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;

import javax.annotation.Resource;

public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisConnection redisConnections;



    public Result login(User user) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Long userId = userMapper.login(user);
            if(userId == null) {
                result.setMsg("Username or password wrong");
            } else {
                result.setMsg("Login seccessfully!");
                result.setSuccess(true);
                user.setUserid(Math.toIntExact(userId));
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
