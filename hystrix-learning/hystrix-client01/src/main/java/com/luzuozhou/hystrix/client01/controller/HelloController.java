package com.luzuozhou.hystrix.client01.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
        return "helloworld";
    }
    @GetMapping("/timeout")
    @HystrixCommand(fallbackMethod = "fallback")
    public String timeoutTest(){
        try {
            //模拟超时熔断
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        return "success";
    }

    public String fallback(){
        return "fallback";
    }

}
