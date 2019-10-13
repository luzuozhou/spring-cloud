package com.luzuozhou.hystrix.client01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author huangxl
 * Created on 2019/10/12
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableSwagger2
public class HystrixClient01Application {
    public static void main(String[] args) {
        SpringApplication.run(HystrixClient01Application.class, args);
    }
}
