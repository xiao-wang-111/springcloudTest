package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @date:2022/1/18 14:49
 * @author:xiao-wang
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int add(Payment payment){
        return paymentDao.add(payment);
    }

    public int deleteById(@Param("id") Long id){
        return paymentDao.deleteById(id);
    }

    public int update(Payment payment){
        return paymentDao.update(payment);
    }

    public Payment queryById(@Param("id") Long id){
        return paymentDao.queryById(id);
    }

    public List<Payment> queryAll(){
        return paymentDao.queryAll();
    }
}
