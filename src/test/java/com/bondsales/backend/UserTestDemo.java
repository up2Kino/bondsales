package com.bondsales.backend;

import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.dao.mapper.UserMapper;
import com.bondsales.backend.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestDemo {

    @Autowired
    UserMapper mapper;
    @Autowired
    UserService userService;

    @Test
    public void testSelectByPrimaryKey() {
        User user1 = mapper.selectByPrimaryKey(1L);
        System.out.println(user1.getUsername());
        assertNotNull(user1);
    }

    @Test
    public void testInsert() {
        User user2 = new User();
        user2.setUserid(123L);
        user2.setUsername("小明");
        user2.setPassword("123456");
        user2.setLogname("小明123");
        userService.insertUser(user2);
        assertTrue(userService.login("小明123", "123456"));
    }
}

