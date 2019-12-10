package com.luzuozhou.file.client.feign;

import com.luzuozhou.file.client.feign.impl.FileServerFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "file-upload-server",fallback = FileServerFeignImpl.class)
public interface FileServerFeign {
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestPart("file") MultipartFile file, @RequestParam(value = "time", defaultValue = "2000") Long time);
}
