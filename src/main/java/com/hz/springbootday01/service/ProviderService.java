package com.hz.springbootday01.service;

import com.hz.springbootday01.entity.Provider;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/4/6 19:12
 * @Version 1.5
 */

public interface ProviderService {

    /**
     * 添加供应商
     * @param provider
     * @return
     */
    public Integer AddProvider(Provider provider);
    /**
     * 多条件组合查询
     * 翻页查询供应商信息
     * @param curr_page  当前页
     * @param page_size 每页显示条数
     * @return
     */
    public List<Provider> findProviderList(Integer curr_page, Integer page_size, String proName,String proDesc
    );

    /**
     * 获取总数据数
     * @param proName 供应商名称
     * @param proDesc 供应商描述
     * @return
     */
    public Integer findProviderListCount(String proName,String proDesc);

    /**
     * 修改供应商
     * @param provider
     * @return
     */
    public Integer updateProvider(Provider provider);



    /**
     * 删除供应商
     * @param id
     * @return
     */
    public int delProviderById(Integer id);
    public Provider findProviderById(Integer id);



}
