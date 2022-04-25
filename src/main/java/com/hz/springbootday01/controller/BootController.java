package com.hz.springbootday01.controller;

import com.hz.springbootday01.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author suolong
 * @Date 2022/4/6 16:48
 * @Version 1.5
 */
@Controller
public class BootController {
    @Autowired
    private User user;

    @RequestMapping("/showUser")
    @ResponseBody
    public String showUser(){
        System.out.println(user.getUserName());
        return user.getUserName();
    }
}
