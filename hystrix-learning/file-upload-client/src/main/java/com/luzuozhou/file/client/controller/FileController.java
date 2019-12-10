package com.luzuozhou.file.client.controller;

import com.luzuozhou.file.client.feign.FileServerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author huangxl
 * @create 2019-12-09 16:40
 */
@RestController
public class FileController {
    @Autowired
    private FileServerFeign fileServerFeign;

    @PostMapping("/upload")
    public String upload(@RequestPart("file") MultipartFile file, @RequestParam(value = "time",defaultValue = "2000") Long time) {
        return fileServerFeign.upload(file,time);
    }
}
