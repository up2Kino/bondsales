package com.bondsales.backend.fileoperation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHandler {
    void readFile(String fileName) throws IOException {
        FileInputStream fstream = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine = "";
        while ((strLine = br.readLine()) != null) {
            String string = strLine;
            String[] parts = string.split(",");
            String userid = parts[0];
            String bondid = parts[1];
            String price = parts[2];
            String date = parts[3];

            System.out.println(userid +" " + bondid + " " + price + " " + date +" ");

        }
        br.close();
    }
}
