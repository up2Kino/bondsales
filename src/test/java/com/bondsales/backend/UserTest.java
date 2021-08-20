package com.bondsales.backend;

import com.bondsales.backend.controller.UserController;
import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.dao.mapper.UserMapper;
import com.google.gson.Gson;
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
        user1.setUserid(4L);
        user1.setLogname("mulla196");
        user1.setUsername("mulla196");
        user1.setPassword("XUSHAN");
//        System.out.println(new Gson().toJson(user1));
        userController.insert(user1);

    }

}
