package com.bondsales.backend.controller;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import com.bondsales.backend.dao.entity.Sales;
import com.bondsales.backend.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UploadController {

    @Autowired
    SalesService salesService;

    @PostMapping("/upload")
    public void uploadFile(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    String[] dataArr = line.split(",");
                    String userName = dataArr[1];
                    String bondName = dataArr[3];
                    long price = Long.valueOf(dataArr[4]);

                    String dt = dataArr[5];
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date date =  formatter.parse(dt);
                    Sales sales = new Sales();
                    sales.setUserName(userName);
                    sales.setBondName(bondName);
                    sales.setPrice(price);
                    sales.setDate(date);
                    salesService.insertSales(sales);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        return salesList;
    }

}
