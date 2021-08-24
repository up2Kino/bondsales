/**
 * 债券信息业务模块流程的控制，调用BondService接口控制业务流程
 */
package com.bondsales.backend.controller;

import com.bondsales.backend.service.BondService;
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
    public String ListBond() {
        return bondService.ListBond();
    }
}
