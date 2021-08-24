package com.bondsales.backend.dao.mapper;

import static org.junit.Assert.assertNotNull;

import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest

public class UserMapperTest {

    @Autowired
    UserMapper mapper;
    @Autowired
    UserService userService;

    @Test
    public void testSelectByPrimaryKey() {
        User user = mapper.selectByPrimaryKey(1L);
        System.out.println(user.getUsername());
        assertNotNull(user);
    }
}