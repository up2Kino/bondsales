package com.bondsales.backend.controller;

import com.bondsales.backend.common.ConstantUtils;
import com.bondsales.backend.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/fileUpload")
    @ResponseBody
    public void fileUpload(MultipartFile file) throws IOException {
        int index=1;

        try (InputStream inputStream = file.getInputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter writer = new BufferedWriter(new FileWriter(ConstantUtils.FILE_NAME+index+".txt"));
            String line = null;
            int splitRow = 300000;


            try {
                while ((line = reader.readLine()) != null) {
                    if(splitRow <= 0 ){
                        // write the file and flush
                        index++;
                        writer.flush();
                        writer.close();
                        writer = new BufferedWriter(new FileWriter(ConstantUtils.FILE_NAME+index+".txt"));
                        splitRow = 300000;
                    }
                    writer.write(line);
                    writer.newLine();
                    splitRow--;
                }
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                    inputStream.close();
                    writer.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // run
        for (int i = 1; i <= index; i++) {
            fileService.setNum(i);
            fileService.run();
        }
        System.out.println("finish!");
    }
}
