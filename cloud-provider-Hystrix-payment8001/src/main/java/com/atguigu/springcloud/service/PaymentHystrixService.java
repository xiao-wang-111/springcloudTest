package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @date:2022/1/24 18:17
 * @author:xiao-wang
 */
@Service
public class PaymentHystrixService {

    public String paymentInfo_OK(Integer id){
        return "线程池： "+ Thread.currentThread().getName()+"    id="+id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String paymentInfo_TimeOut(Integer id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： "+ Thread.currentThread().getName()+"    id="+id;
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "8001支付服务超时";
    }

    //=======服务熔断
    @HystrixCommand(fallbackMethod = "paymentFallback",commandProperties = {
            // 开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(Integer id){
        if(id < 0){
            throw new RuntimeException("id不能为负");
        }else{
            String s = IdUtil.simpleUUID();
            return "流水号为："+s;
        }
    }

    public String paymentFallback(Integer id){
        return "id不能为负，请重新输入";
    }

}
