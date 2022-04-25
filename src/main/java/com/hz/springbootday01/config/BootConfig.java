package com.hz.springbootday01.config;

import com.hz.springbootday01.entity.User;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author suolong
 * @Date 2022/4/6 16:46
 * @Version 1.5
 */
@Configuration
public class BootConfig {

    /*@Value("${uname}")*/
    public String uname;


    @Bean
    public User newUser(){
        User user = new User();

        System.out.println("uname==="+uname);
        user.setUserName(uname);
        return user;
    }
}
