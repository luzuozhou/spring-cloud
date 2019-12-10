package com.luzuozhou.file.client.feign.impl;

import com.luzuozhou.file.client.feign.FileServerFeign;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author huangxl
 * @create 2019-12-09 19:46
 */
@Component
public class FileServerFeignImpl implements FileServerFeign {
    @Override
    public String upload(MultipartFile file, Long time) {
        return "上传文件超时";
    }
}
