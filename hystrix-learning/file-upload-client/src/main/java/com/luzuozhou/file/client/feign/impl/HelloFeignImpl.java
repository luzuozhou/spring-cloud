package com.luzuozhou.file.client.feign.impl;

import com.luzuozhou.file.client.feign.HelloFeign;
import org.springframework.stereotype.Component;

/**
 * @author huangxl
 * @create 2019-12-10 09:59
 */
@Component
public class HelloFeignImpl implements HelloFeign {
    @Override
    public String hello(Long time) {
        System.out.println("===feign  timeout===");
        return "feign timeout";
    }
}
