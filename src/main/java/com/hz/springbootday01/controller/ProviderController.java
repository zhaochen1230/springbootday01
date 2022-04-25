package com.hz.springbootday01.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hz.springbootday01.entity.Provider;
import com.hz.springbootday01.entity.User;
import com.hz.springbootday01.service.ProviderService;
import com.hz.springbootday01.utils.JsonMassage;
import com.hz.springbootday01.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author suolong
 * @Date 2022/4/6 19:15
 * @Version 1.5
 */
@Controller
@RequestMapping("/provider")
public class ProviderController {

    //注册service
    @Autowired
    private ProviderService providerService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private Serializable serializable;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //翻页排序
    @RequestMapping(value = "/findProviderList", method = RequestMethod.GET)
    @ResponseBody
    public JsonMassage<List<Provider>> findProviderList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "limit1", defaultValue = "10") Integer limit1,
            String proName,
            String proDesc
    ) {
        List<Provider> list = providerService.findProviderList(page, limit1, proName, proDesc);
        Integer count = providerService.findProviderListCount(proName, proDesc);

        JsonMassage<List<Provider>> jsonMassage = new JsonMassage<List<Provider>>();
        jsonMassage.setCode(0);
        jsonMassage.setMsg("请求成功");
        jsonMassage.setCount(count);
        jsonMassage.setData(list);
        return jsonMassage;
    }

    @RequestMapping(value = "addProvider", method = RequestMethod.POST)
    @ResponseBody
    public ResultJson AddProvider(Provider provider) {
        System.out.println(provider.toString());
        int i = providerService.AddProvider(provider);
        return new ResultJson(i);
    }
    //修改供应商信息
    @RequestMapping(value = "/updateProvider",method = RequestMethod.POST)
    @ResponseBody
    public ResultJson updateProvider(Provider provider){
        System.out.println(provider.toString());
        int i = providerService.updateProvider(provider);
        return new ResultJson(i);
    }

    //根据ID查找供应商
    @RequestMapping("/findProviderById/{id}")
    public String findProviderById(@PathVariable("id") String id, Model model){
        Provider providerById = providerService.findProviderById(Integer.valueOf(id));
        model.addAttribute("pro",providerById);

        return "provider_edit";
    }

    @RequestMapping(value = "findRedis",method = RequestMethod.GET)
    @ResponseBody
    public String findRedis(){
     //存储存储字符串
//     redisTemplate.opsForValue().set("name","tom");
     //设置失效时间
     //redisTemplate.opsForValue().set("name","marry",10,TimeUnit.SECONDS);
// 存储浮点
//        template.opsForValue().increment("sex",1);
////        System.out.println(redisTemplate.opsForValue().get("sex"));
        Provider provider=providerService.findProviderById(1);
        String json = JSON.toJSONString(provider);
        RedisSerializer rs = new StringRedisSerializer();
        stringRedisTemplate.setStringSerializer(rs);
       ValueOperations ops = stringRedisTemplate.opsForValue();
       ops.set("provider1",json,10,TimeUnit.SECONDS);
//取出对象
        String str = (String)stringRedisTemplate.opsForValue().get(json);
        return "成功";
    }

}
