package com.luzuozhou.file.client.feign;

import com.luzuozhou.file.client.feign.impl.HelloFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huangxl
 * @create 2019-12-10 09:29
 */
@FeignClient(name = "hystrix-client", fallback = HelloFeignImpl.class)
public interface HelloFeign {
    @GetMapping("/hello")
    String hello(@RequestParam(value = "time", defaultValue = "2000") Long time);
}
