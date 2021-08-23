package com.bondsales.backend.service;


import com.bondsales.backend.dao.entity.Sales;
import com.bondsales.backend.dao.mapper.SalesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
//@ComponentScan({"java.lang.Integer"})
public class MyThread extends Thread{
    @Autowired
    private SalesMapper salesMapper;

    private Integer num;

    static String fileName = "/Users/nicole/Desktop/file/receivedFile";

    @Autowired
    public MyThread(Integer num){

        this.num = num;
    }

    public void run(){

        /*
        FileHandler fileHandler = new FileHandler();
        object converted into method
         */
        try{
//            String sPath = fileName+"_"+ (num+1)+".txt";
            String sPath = fileName+"_"+ (1)+".txt";
//            System.out.println("**********Start of file" + fileName+"_"+ (num+1)+".txt***************");
            readFile(sPath);
//            System.out.println("**********End of file" + fileName+"_"+ (num+1)+".txt***************");
            deleteFile(sPath);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


    public boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);

        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.deleteOnExit();
            flag = true;
        }
        System.out.println(flag);
        return flag;
    }


    public void readFile(String fileName) throws IOException, ParseException {
        FileInputStream fstream = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine = "";
        while ((strLine = br.readLine()) != null) {
            String string = strLine;
            String[] parts = string.split(",");
//            String userid = parts[0];
//            String bondid = parts[1];
//            String price = parts[2];
//            String date = parts[3];

            Sales sale = new Sales();
            sale.setUserid(Long.parseLong(parts[0]));
            sale.setBondid(Long.parseLong(parts[1]));
            sale.setPrice(Long.parseLong(parts[2]));
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            sale.setDate(df.parse(parts[3]));
            System.out.println(sale);
            try{
                salesMapper.insert(sale);
            } catch (Exception e){
//                e.printStackTrace();
                System.out.println("wrong");
            }
//            salesMapper.insert(sale);

//            System.out.println(userid +" " + bondid + " " + price + " " + date +" ");

        }
        br.close();
    }




}
