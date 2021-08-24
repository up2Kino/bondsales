package com.bondsales.backend.service;

import com.bondsales.backend.dao.mapper.BondMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BondService {
    @Resource
    private BondMapper bondMapper;

    public String ListBond() {
        Gson gson = new Gson();
        return gson.toJson(bondMapper.selectAll());
    }


}
