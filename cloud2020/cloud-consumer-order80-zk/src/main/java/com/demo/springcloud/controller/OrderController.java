package com.demo.springcloud.controller;

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //通过在zookeeper上注册过的微服务名称调用
    private static final String PAYMENT_URL = "http://cloud-provider-payment";

    //没讲ribbon前使用RestTemplate完成
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String getPayment() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
    }
}
