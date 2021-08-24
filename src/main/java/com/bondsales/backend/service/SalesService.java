package com.bondsales.backend.service;

import com.bondsales.backend.common.SalesInfo;
import com.bondsales.backend.dao.entity.Sales;
import com.bondsales.backend.dao.mapper.SalesMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SalesService {
    @Resource
    private SalesMapper salesMapper;

    public boolean insertSales(Sales sale) {
        try {
            salesMapper.insert(sale);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public String listAllSale(){
        Gson gson = new Gson();
        return gson.toJson(salesMapper.selectAll());
    }

    public List<SalesInfo> lookUp(SalesInfo salesInfo){
        return salesMapper.lookUp(salesInfo);
    }

    public Long lookUpCount(SalesInfo salesInfo){
        return salesMapper.lookUpCount(salesInfo);
    }

    public String latestRecords(){
        Gson gson = new Gson();
        return gson.toJson(salesMapper.latestRecords());
    }

    public int Update(Sales sale){
        return salesMapper.updateByPrimaryKey(sale);
    }

    public int delete(Long id){
        return salesMapper.deleteByPrimaryKey(id);
    }
}
