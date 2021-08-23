package com.bondsales.backend;

import com.bondsales.backend.controller.UserController;
import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.dao.mapper.UserMapper;
import com.google.gson.Gson;
import org.apache.ibatis.jdbc.Null;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    @Autowired
    UserController userController;

    @Test
    public void testInsert(){
        User user1=new User();
        user1.setUserid(null);
//        user1.setLogname("diana96");
        user1.setUsername("dianaHuaXin");
        user1.setPassword("dfafdss");
        System.out.println(userController.insert(user1));
//        System.out.println(new Gson().toJson(user1));

    }

}
