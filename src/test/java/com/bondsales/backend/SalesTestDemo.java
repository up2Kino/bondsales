package com.bondsales.backend;

import com.bondsales.backend.dao.entity.Sales;
import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.dao.mapper.SalesMapper;
import com.bondsales.backend.dao.mapper.UserMapper;
import com.bondsales.backend.service.SalesService;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalesTestDemo {


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

    @Test
    public void testInsert() throws ParseException {
        Sales sales2 = new Sales();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd");
        sales2.setSellid(110L);
        sales2.setUserid(1L);
        sales2.setBondid(1L);
        sales2.setPrice(3000L);
        sales2.setDate(date.parse("2020-11-11"));
        assertTrue(salesService.insertSales(sales2) == true);
    }
}