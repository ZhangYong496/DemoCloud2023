package com.hambo.cloud.controller;


import com.hambo.cloud.entities.CommonResult;
import com.hambo.cloud.entities.Payment;
import com.hambo.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功+ serverPort" + serverPort, result);
        } else {
            return new CommonResult(500, "插入数据库异常", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        if (result != null) {
            return new CommonResult(200, "查询数据成功serverPort" + serverPort, result);
        } else {
            return new CommonResult(500, "没有查询对应记录", null);
        }
    }

}
