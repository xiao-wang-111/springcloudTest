package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @date:2022/1/24 16:44
 * @author:xiao-wang
 */
@Configuration
public class FeignLog {

    @Bean
    Logger.Level logLevel(){
        return Logger.Level.FULL;
    }
}
