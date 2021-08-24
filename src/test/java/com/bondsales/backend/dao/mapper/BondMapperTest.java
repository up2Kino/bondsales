package com.bondsales.backend.dao.mapper;

import com.bondsales.backend.dao.entity.Bond;
import com.bondsales.backend.service.BondService;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest

public class BondMapperTest {

    @Autowired
    BondMapper mapper;
    @Autowired
    BondService bondService;

    @Test
    public void testSelectByPrimaryKey() {
        Bond bond1 = mapper.selectByPrimaryKey(1L);
        assertNotNull(bond1);
    }


}