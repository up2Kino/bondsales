package com.bondsales.backend.service;

import com.bondsales.backend.dao.mapper.BondMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BondService {
    @Autowired
    private BondMapper bondMapper;

    public String ListBond(){
        Gson gson = new Gson();
        return gson.toJson(bondMapper.selectAll());
    }

}
