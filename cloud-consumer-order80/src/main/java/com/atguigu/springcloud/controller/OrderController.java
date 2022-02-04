package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @date:2022/1/18 20:41
 * @author:xiao-wang
 */
@RestController
@Slf4j
public class OrderController {

    //private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/add")
    public CommonResult<Payment> add(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/deleteById/{id}")
    public void delete(@PathVariable("id") Long id){
       restTemplate.delete(PAYMENT_URL + "/payment/delete/"+ id);
    }

    @GetMapping(value = "/consumer/payment/update")
    public void update(Payment payment){
        restTemplate.put(PAYMENT_URL + "/payment/update",payment);
    }

    @GetMapping(value = "/consumer/payment/queryById/{id}")
    public CommonResult<Payment> queryById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/queryById/"+ id,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/queryAll")
    public CommonResult<Payment> queryAll(){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/queryAll",CommonResult.class);
    }
}
