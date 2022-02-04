package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 *
 * @date:2022/1/18 14:49
 * @author:xiao-wang
 */
public interface PaymentService {
    public int add(Payment payment);

    public int deleteById(@Param("id") Long id);

    public int update(Payment payment);

    public Payment queryById(@Param("id") Long id);

    public List<Payment> queryAll();
}
