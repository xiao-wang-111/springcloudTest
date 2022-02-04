package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @date:2022/1/18 14:59
 * @author:xiao-wang
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/add")
    public CommonResult add(@RequestBody Payment payment){
        int result = paymentService.add(payment);
        log.info("-----插入结果为---"+ result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功,server.port="+serverPort,result);
        }else {
            return new CommonResult(404,"插入数据失败",null);
        }
    }
    @DeleteMapping(value = "/payment/delete/{id}")
    public CommonResult deleteById(@PathVariable("id") Long id){
        int result = paymentService.deleteById(id);
        log.info("-----删除结果为---"+ result);
        if(result > 0){
            return new CommonResult(200,"删除数据成功,server.port="+serverPort,result);
        }else {
            return new CommonResult(404,"删除数据失败，id为" + id,null);
        }
    }
    @PutMapping(value = "/payment/update")
    public CommonResult update(@RequestBody Payment payment){
        int result = paymentService.update(payment);
        log.info("-----修改结果为---"+ result);
        if(result > 0){
            return new CommonResult(200,"修改数据成功,server.port="+serverPort,result);
        }else {
            return new CommonResult(404,"修改数据失败",null);
        }
    }

    @GetMapping(value = "/payment/queryById/{id}")
    public CommonResult queryById(@PathVariable("id") Long id){
        Payment result = paymentService.queryById(id);
        log.info("-----查询结果为---"+ result);
        if(result != null){
            return new CommonResult(200,"查询数据成功,server.port="+serverPort,result);
        }else {
            return new CommonResult(404,"查询数据失败，id=" + id,null);
        }
    }

    @GetMapping(value = "/payment/queryAll")
    public CommonResult queryAll(){
        List<Payment> results = paymentService.queryAll();
        log.info("-----查询结果为---"+ results);
        if(results != null){
            return new CommonResult(200,"查询数据成功,server.port="+serverPort,results);
        }else {
            return new CommonResult(404,"查询数据失败",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service名称为："+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("----instance名称:"+instance.getInstanceId()+"\t"+instance.getHost()+ "\t"+instance.getPort()
            +"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }



}
