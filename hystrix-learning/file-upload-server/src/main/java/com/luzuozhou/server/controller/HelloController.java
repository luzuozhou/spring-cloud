package com.luzuozhou.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangxl
 * @create 2019-12-09 16:40
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "time", defaultValue = "2000") Long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
