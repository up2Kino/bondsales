/**
 * 债券销售业务模块流程的控制，调用SalesService接口控制业务流程
 */
package com.bondsales.backend.controller;

import com.bondsales.backend.common.SalesInfo;
import com.bondsales.backend.dao.entity.Sales;
import com.bondsales.backend.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesController {
    @Autowired
    private SalesService salesService;

    @RequestMapping("/ListAllSale")
    @ResponseBody
    public String listSale() {
        return salesService.listAllSale();
    }

    @RequestMapping(value = "/insertSales", method = RequestMethod.POST)
    @ResponseBody
    public boolean insert(@RequestBody SalesInfo salesInfo) {
        Sales sale = new Sales();

        sale.setSellid(null);
        sale.setBondid(salesInfo.getBondid());
        sale.setPrice(salesInfo.getPrice());
        sale.setUserid(salesInfo.getUserid());
        sale.setDate(salesInfo.getDate());

        return salesService.insertSales(sale);
    }

    @RequestMapping(value = "/lookUp", method = RequestMethod.POST)
    @ResponseBody
    public List<SalesInfo> lookUp(@RequestBody SalesInfo salesInfo) {
        if (salesInfo.getPageNumber() != null) {
            Long new_pageNumber = (salesInfo.getPageNumber() - 1) * salesInfo.getNumPerPage();
            salesInfo.setPageNumber(new_pageNumber);
        }
        return salesService.lookUp(salesInfo);
    }

    @RequestMapping(value = "/lookUpCount", method = RequestMethod.POST)
    @ResponseBody
    public Long lookUpCount(@RequestBody SalesInfo salesInfo) {
        return salesService.lookUpCount(salesInfo);
    }

    @RequestMapping("/LatestRecords")
    @ResponseBody
    public String latestRecords() {
        return salesService.latestRecords();
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
        int result = salesService.update(sale);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

}
