package com.bondsales.backend.service;

import com.bondsales.backend.common.SalesInfo;
import com.bondsales.backend.dao.entity.Sales;
import com.bondsales.backend.dao.mapper.SalesMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalesService {
    @Autowired
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

    public List<Sales> lookUp(SalesInfo salesInfo){
        return salesMapper.lookUp(salesInfo);
    }

//    public int Update(Sales sale){
//        return salesMapper.updateByPrimaryKey(sale);
//    }
//
//    public int delete(Long id){
//        return salesMapper.deleteByPrimaryKey(id);
//    }
}
