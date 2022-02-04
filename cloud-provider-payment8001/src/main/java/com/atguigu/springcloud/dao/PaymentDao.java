package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 *
 * @date:2022/1/18 10:57
 * @author:xiao-wang
 */
@Mapper
public interface PaymentDao {
    public int add(Payment payment);

    public int deleteById(@Param("id") Long id);

    public int update(Payment payment);

    public Payment queryById(@Param("id") Long id);

    public List<Payment> queryAll();


}
