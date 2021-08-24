package com.bondsales.backend.controller;

import com.bondsales.backend.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {
    static String fileName = "/Users/nicole/Desktop/file/receivedFile.txt";

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/fileUpload")
    @ResponseBody
    public void fileUpload() throws IOException {
//        int splitRow = 300000;
        int splitRow = 50;
        int end = getLineNum(fileName);
        int numOfFiles = splitField(end, splitRow);

        for(int i=0; i<numOfFiles+1;i++) {
            fileService.setNum(i);
            fileService.run();
        }
        System.out.println("finish!");
        return;
    }

    // get the number of lines
    public int getLineNum(String fileName) throws IOException {
        FileInputStream fstream = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine = "";
        int i = 0;
        while((strLine = br.readLine() )!= null){
            i++;
        }
        return i;
    }


    // split the big file into several files
    public int splitField(int totalLine, int splitRow) {
        try {
            FileInputStream fStream = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
            List<FileWriter> subFileList = new ArrayList<FileWriter>();
            int subFileLines = getSubFileLines(totalLine, splitRow);
            int numOfFiles = getNumOfFiles(subFileList, subFileLines);
            splitFile(totalLine, splitRow, br, subFileList);
            return numOfFiles;
        } catch (Exception e) {
            System.out.println("将大文件拆分成小文件异常，异常：" + e);
        }
        return totalLine;
    }

    // helper function1
    private void splitFile(int totalLine, int splitRow, BufferedReader br, List<FileWriter> subFileList) throws IOException {
        String strLine = "";
        for (Integer rowNum = 1; rowNum <= totalLine; ++rowNum) {
            strLine = br.readLine();
            int subFieldIndex;
            if(rowNum % splitRow == 0){
                subFieldIndex = rowNum / splitRow - 1;
            } else{
                subFieldIndex = rowNum / splitRow;
            }
            subFileList.get(subFieldIndex).append(strLine + "\r\n");
        }

        for (int i = 0; i < subFileList.size(); i++) {
            subFileList.get(i).close();
        }
        br.close();
    }

    // helper function2
    private int getNumOfFiles(List<FileWriter> subFileList, int subFileLines) throws IOException {
        int numOfFiles = 0;
        for (int i = 0; i < subFileLines; i++) {
            subFileList.add(new FileWriter(fileName.substring(0, fileName.length() - 4) + "_" + (i + 1) + ".txt"));
            numOfFiles = i;
        }
        return numOfFiles;
    }

    // helper function3
    private static int getSubFileLines(int totalLine, int splitRow) {
        int subFileLines;
        if(totalLine % splitRow == 0 ){
            subFileLines = totalLine / splitRow;
        }  else{
            subFileLines = (totalLine / splitRow) + 1;
        }
        return subFileLines;
    }


}
