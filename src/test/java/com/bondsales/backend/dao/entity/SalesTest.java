package com.bondsales.backend.dao.entity;

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

public class SalesTest {

    @Autowired
    SalesService salesService;

    @Test
    public void testInsert() throws ParseException {
        Sales sales = new Sales();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd");
        sales.setSellid(null);
        sales.setUserid(1L);
        sales.setBondid(1L);
        sales.setPrice(3000L);
        sales.setDate(date.parse("2020-11-11"));
        System.out.println(sales.getPrice());
        System.out.println(sales.getBondid());
        System.out.println(sales.getSellid());
        System.out.println(sales.getDate());
        assertTrue(salesService.insertSales(sales) == true);
    }

}