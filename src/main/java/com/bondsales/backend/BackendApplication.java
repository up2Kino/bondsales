package com.bondsales.backend;

import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
public class BackendApplication {

    @Resource
    @Qualifier("userMapper")
    private UserMapper userMapper;


    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

}
