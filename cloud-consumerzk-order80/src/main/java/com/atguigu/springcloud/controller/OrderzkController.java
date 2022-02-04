package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @date:2022/1/23 16:44
 * @author:xiao-wang
 */
@RestController
@Slf4j
public class OrderzkController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/order/zk")
    public String zk(){
        return restTemplate.getForObject("http://cloud-provider-service/payment/zk",String.class);
    }
}
