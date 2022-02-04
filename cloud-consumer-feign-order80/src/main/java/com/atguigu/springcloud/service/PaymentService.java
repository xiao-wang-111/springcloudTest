package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 *
 * @date:2022/1/24 14:59
 * @author:xiao-wang
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @PostMapping(value = "/payment/add")
    CommonResult add(@RequestBody Payment payment);

    @DeleteMapping(value = "/payment/delete/{id}")
    CommonResult deleteById(@PathVariable("id") Long id);

    @PutMapping(value = "/payment/update")
    CommonResult update(@RequestBody Payment payment);

    @GetMapping(value = "/payment/queryById/{id}")
    CommonResult queryById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/queryAll")
    CommonResult queryAll();

    @GetMapping(value = "/payment/timeout")
    String timeOut();

}
