package com.bondsales.backend;

import com.bondsales.backend.dao.entity.BondTest;
import com.bondsales.backend.dao.entity.Sales;
import com.bondsales.backend.dao.entity.SalesTest;
import com.bondsales.backend.dao.entity.UserTest;
import com.bondsales.backend.dao.mapper.BondMapperTest;
import com.bondsales.backend.dao.mapper.SalesMapperTest;
import com.bondsales.backend.dao.mapper.UserMapperTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
//
class BackendApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("这是一个测试");
    }

}

