package com.bondsales.backend.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class GetFileController {

//    @RequestMapping(value = "/files/{file_name}", method = RequestMethod.POST)
//    public Response upload(@RequestParam("uploadFile") MultipartFile uploadFile) throws IOException {
//        if (null == uploadFile) {
//            return response("上传失败，无法找到文件！");
//        }
//        // BMP、JPG、JPEG、PNG、GIF
//        String fileName = uploadFile.getOriginalFilename().toLowerCase();
//        if (!fileName.endsWith(".bmp") && !fileName.endsWith(".jpg")
//                && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png")
//                && !fileName.endsWith(".gif")) {
//            return response("上传失败，请选择BMP、JPG、JPEG、PNG、GIF文件！");
//        }
//        //逻辑处理
//        return response("成功");
//    }
}
