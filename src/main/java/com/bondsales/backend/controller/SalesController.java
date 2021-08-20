package com.bondsales.backend.controller;

import com.bondsales.backend.common.SalesInfo;
import com.bondsales.backend.dao.entity.Sales;
import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.service.SalesService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


    @RequestMapping(value = "/insertSales", method = RequestMethod.POST)
    @ResponseBody
    public boolean insert(SalesInfo salesInfo) {
        Sales sale = new Sales();
        sale.setSellid(null);
        sale.setBondid(salesInfo.getBondid());
        sale.setDate(salesInfo.getDate());
        sale.setPrice(salesInfo.getPrice());
        sale.setUserid(salesInfo.getUserid());
        return salesService.insertSales(sale);
    }


//    public void temp(){
//        DateFormat df=new SimpleDateFormat("MM/dd/yyyy");
//        Date d1 = new Date();
//        //DateFormat是抽象类 ，抽象类不可以直接创建对象，所以我们创建子类的对象
//        try {
//            d1 = df.parse("08/20/2021");//这个格式必须按照上面给出的格式进行转化否则出错
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        DateFormat dfRight = new SimpleDateFormat("yyyy-MM-dd");
//        String d2= dfRight.format(d1);
//        System.out.println(d2);
//    }


}
