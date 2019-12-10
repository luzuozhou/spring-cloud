package com.luzuozhou.server.controller;

import com.luzuozhou.server.common.FileUploadHelper;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author huangxl
 * @create 2019-12-09 16:13
 */
@RestController
public class FileController {
    public static final String ROOT_PATH = "E:\\test_files_root\\";
    public static final String RELATIVE_DIR = "test\\";

    @PostMapping(value = "/upload")
    public String upload(@RequestPart("file") MultipartFile file,
                         @RequestParam(value = "time",defaultValue = "2000") Long time,
                         HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            System.out.println(key + "=" + request.getHeader(key));
        }

        System.out.println("==========upload===========");
        try {
            FileUploadHelper.saveFile(file, ROOT_PATH, RELATIVE_DIR);
            Thread.sleep(time);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
