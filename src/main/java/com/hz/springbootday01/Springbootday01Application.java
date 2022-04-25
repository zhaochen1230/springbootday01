package com.hz.springbootday01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//        (scanBasePackages = {"com.hz.springbootday01.service","com.hz.springbootday01.controller"})
@MapperScan(basePackages = {"com.hz.springbootday01.dao"})
@EnableTransactionManagement//开启事务
//@EnableCaching //开启缓存
public class Springbootday01Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootday01Application.class, args);
    }

}
