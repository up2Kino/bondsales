package com.bondsales.backend;

import com.bondsales.backend.controller.UserController;
import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.dao.mapper.UserMapper;
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
        user1.setUserid(5L);
        user1.setUsername("nicolewang");
        user1.setName("王佳怡");
        user1.setPassword("abcdcdajlrf");
        System.out.println(userController.insert(user1));

    }

}
