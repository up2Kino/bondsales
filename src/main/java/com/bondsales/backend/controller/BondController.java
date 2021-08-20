package com.bondsales.backend.controller;

import com.bondsales.backend.service.BondService;
import com.bondsales.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BondController {
    @Autowired
    private BondService bondService;

    @RequestMapping("/ListBond")
    @ResponseBody
    public String ListBond(){
        return bondService.ListBond();
    }
}
