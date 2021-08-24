package com.bondsales.backend.dao.entity;

import com.bondsales.backend.service.BondService;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class BondTest {

    @Autowired
    BondService bondService;

    @Test
    public void testInsert()  {
        Bond bond = new Bond();
        bond.setBondid(200L);
        bond.setBondname("证券88");
        System.out.println(bond.getBondname());
        assertEquals("证券88",bond.getBondname());
    }
}
