package com.bondsales.backend;

import com.bondsales.backend.dao.entity.Bond;
import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.dao.mapper.BondMapper;
import com.bondsales.backend.dao.mapper.UserMapper;
import com.bondsales.backend.service.BondService;
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
public class BondTestDemo {

    @Autowired
    BondMapper mapper;
    @Autowired
    BondService bondService;


    @Test
    public void testSelectByPrimaryKey() {
        Bond bond1 = mapper.selectByPrimaryKey(1L);
        System.out.println(bond1.getBondname());
        assertNotNull(bond1);
    }

    @Test
    public void testInsert()  {
        Bond bond2 = new Bond();
        bond2.setBondid(200L);
        bond2.setBondname("证券88");
        assertEquals("证券88",bond2.getBondname());
    }
}