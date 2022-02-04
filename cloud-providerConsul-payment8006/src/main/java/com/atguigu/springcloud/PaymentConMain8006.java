package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Description:
 *
 * @date:2022/1/23 17:43
 * @author:xiao-wang
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConMain8006.class,args);
    }
}
