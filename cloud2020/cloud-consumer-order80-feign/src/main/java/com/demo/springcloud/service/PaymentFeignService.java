package com.demo.springcloud.service;

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-payment-service")   // EurekaServer中注册的服务名
public interface PaymentFeignService {

    /**
     * 和服务提供方controller层中的方法一致
     **/
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    //超时接口
    @GetMapping(value = "/payment/get/timeOut/{id}")
    public CommonResult<Payment> getPaymentByIdTimeOut(@PathVariable("id") Long id);
}
