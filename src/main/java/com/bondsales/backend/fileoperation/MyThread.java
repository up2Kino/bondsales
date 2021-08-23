package com.bondsales.backend.fileoperation;
import java.io.*;

public class MyThread {
    private int num;
    static String fileName = "/Users/nicole/Desktop/file/receivedFile";

    MyThread(int num){

        this.num = num;
    }

    public void run(){

        FileHandler fileHandler = new FileHandler();
        try{
            String sPath = fileName+"_"+ (num+1)+".txt";
            System.out.println("**********Start of file" + fileName+"_"+ (num+1)+".txt***************");
            fileHandler.readFile(sPath);
            System.out.println("**********End of file" + fileName+"_"+ (num+1)+".txt***************");
            deleteFile(sPath);

        } catch (IOException e) {
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
}
