package com.luzuozhou.file.client.controller;

import com.luzuozhou.file.client.feign.HelloFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangxl
 * @create 2019-12-09 16:40
 */
@RestController
public class HelloController {
    @Autowired
    private HelloFeign helloFeign;

    @HystrixCommand(defaultFallback = "fallback")
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "time", defaultValue = "2000") Long time) {
        return helloFeign.hello(time);
    }

    public String fallback() {
        System.out.println("===HelloController  timeout========");
        return "fail";
    }
}
