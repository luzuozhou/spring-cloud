package com.luzuozhou.hystrix.client01.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangxl
 * Created on 2019/10/12
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World！";
    }

    @GetMapping("/propertiesTimeout")
    @HystrixCommand(fallbackMethod = "fallback")
    public String propertiesTimeout() {
        try {
            //模拟超时
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            System.out.println("propertiesTimeout");
        }
        return "success";
    }

    @GetMapping("/annotationTimeout")
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String annotationTimeout() {
        try {
            //模拟超时
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            System.out.println("annotationTimeout");
        }
        return "success";
    }

    @GetMapping("/defaultTimeout")
    @HystrixCommand(fallbackMethod = "fallback")
    public String defaultTimeout() {
        try {
            //模拟超时
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            System.out.println("defaultTimeout");
        }
        return "success";
    }

    public String fallback() {
        return "fallback";
    }
}
