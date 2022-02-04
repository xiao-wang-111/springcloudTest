package com.atguigu.myrule;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @date:2022/1/23 20:04
 * @author:xiao-wang
 */
@Configuration
public class MyRibbonRule {
    @Bean
    public RandomRule getRandomRule(){
        return new RandomRule();
    }
}
