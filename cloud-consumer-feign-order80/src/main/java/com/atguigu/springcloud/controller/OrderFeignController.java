package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @date:2022/1/24 15:02
 * @author:xiao-wang
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/feign/add")
    public CommonResult add(Payment payment){
        return paymentService.add(payment);
    }

    @GetMapping(value = "/feign/delete/{id}")
    public CommonResult deleteById(@PathVariable("id") Long id){
        return paymentService.deleteById(id);
    }

    @GetMapping(value = "/feign/update")
    public CommonResult update(Payment payment){
        return paymentService.update(payment);
    }

    @GetMapping(value = "/feign/queryById/{id}")
    public CommonResult queryById(@PathVariable("id") Long id){
        return paymentService.queryById(id);
    }

    @GetMapping(value = "/feign/queryAll")
    public CommonResult queryAll(){
        return paymentService.queryAll();
    }

    @GetMapping(value = "/feign/timeout")
    public String timeOut(){
        return paymentService.timeOut();
    }
}
