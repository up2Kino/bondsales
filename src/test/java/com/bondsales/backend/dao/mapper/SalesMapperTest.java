package com.bondsales.backend.dao.mapper;

import com.bondsales.backend.dao.entity.Sales;
import com.bondsales.backend.dao.mapper.SalesMapper;
import com.bondsales.backend.service.SalesService;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalesMapperTest {

    @Autowired
    SalesMapper mapper;
    @Autowired
    SalesService salesService;

    @Test
    public void testSelectByPrimaryKey() {
        Sales sales1 = mapper.selectByPrimaryKey(1L);
        System.out.println(sales1.getPrice());
        assertNotNull(sales1);
    }
}