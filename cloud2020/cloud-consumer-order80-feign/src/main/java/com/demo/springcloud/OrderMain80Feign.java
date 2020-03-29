package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //开启feign
public class OrderMain80Feign {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80Feign.class, args);
    }
}
