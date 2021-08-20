package com.bondsales.backend.controller;

import com.bondsales.backend.common.SalesInfo;
import com.bondsales.backend.dao.entity.Sales;
import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.service.SalesService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SalesController {
    @Autowired
    private SalesService salesService;

    @RequestMapping("/ListSale")
    @ResponseBody
    public String ListSale(){
        return salesService.ListSale();
    }

    @RequestMapping(value = "/deleteSale", method = RequestMethod.GET)
    public String delete(Long id) {
        int result = salesService.delete(id);
        if (result < 1) {
            return "删除失败";
        } else {
            return "删除成功";
        }
    }

    @RequestMapping(value = "/updateSale", method = RequestMethod.POST)
    public String update(Sales sale) {
        int result = salesService.Update(sale);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

//    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
//    public boolean insert(Sales sale) {
//        return salesService.insertSales(sale);
//    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    @ResponseBody
    public boolean insert(SalesInfo salesInfo) {
        Sales sale = new Sales();
        sale.setBondid(salesInfo.getBondid());
        sale.setDate(salesInfo.getDate());
        sale.setPrice(salesInfo.getPrice());
        sale.setUserid(salesInfo.getUserid());
        return salesService.insertSales(sale);
    }

}
