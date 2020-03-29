package com.demo.springcloud.controller;

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;
import com.demo.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/feign/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("feign 调用 id:{}", id);
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/feign/payment/get/timeOut/{id}")
    public CommonResult<Payment> getPaymentTimeOut(@PathVariable("id") Long id) {
        log.info("feign 调用 timeout id:{}", id);
        return paymentFeignService.getPaymentByIdTimeOut(id);
    }
}
