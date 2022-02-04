package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @date:2022/1/25 16:08
 * @author:xiao-wang
 */
@Component
public class OrderHystrixFallback implements OrderHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "OrderHystrixFallback处理异常";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "OrderHystrixFallback处理异常";
    }
}
