package com.bondsales.backend.service;


import com.bondsales.backend.dao.entity.Sales;
import com.bondsales.backend.dao.mapper.SalesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService extends Thread{

    @Resource
    private SalesMapper salesMapper;

    private int num;

    static String fileName = "/Users/nicole/Desktop/file/receivedFile";

    public void run(){
        int new_num = this.getNum();
        try{
            String sPath = fileName+"_"+ (new_num+1)+".txt";
            readFile(sPath);
            deleteFile(sPath);
            this.interrupt();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


    public boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);

        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        System.out.println(flag);
        return flag;
    }


    public void readFile(String fileName) throws IOException, ParseException {
        FileInputStream fstream = null;
        BufferedReader br = null;

        try{
            fstream = new FileInputStream(fileName);
            br = new BufferedReader(new InputStreamReader(fstream));
            String strLine = "";
            List<Sales> record = new ArrayList<>();

            while ((strLine = br.readLine()) != null) {
                String string = strLine;
                String[] parts = string.split(",");

                Sales sale = new Sales();
                sale.setSellid(null);
                sale.setUserid(Long.parseLong(parts[0]));
                sale.setBondid(Long.parseLong(parts[2]));
                sale.setPrice(Long.parseLong(parts[4]));
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

                sale.setDate(df.parse(parts[5]));
                record.add(sale);
            }

            try{
                salesMapper.insertBatch(record);
            } catch (Exception e){
                System.out.println(e);
                System.out.println("wrong");
            }

        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void setNum(int num){
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
