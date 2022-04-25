package com.hz.springbootday01.service.impl;

import com.hz.springbootday01.dao.ProviderDao;
import com.hz.springbootday01.entity.Provider;
import com.hz.springbootday01.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/4/6 19:13
 * @Version 1.5
 */
@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderDao providerDao;
    @Transactional//开启事务



    //翻页
    @Override
    public List<Provider> findProviderList(Integer curr_page, Integer page_size, String proName, String proDesc) {
        //计算偏移量 = (当前页-1)*每页显示条数
        Integer pyl = (curr_page-1)*page_size;

        return providerDao.findProviderList(pyl,page_size,proName,proDesc);

    }
    @Override
    public Integer findProviderListCount(String proName, String proDesc) {
        return providerDao.findProviderListCount(proName,proDesc);
    }
    //添加供应商
    @Override
    public Integer AddProvider(Provider provider) {
        return providerDao.AddProvider(provider);
    }
    //修改供应商
    @Override
    public Integer updateProvider(Provider provider) {
        return providerDao.updateProvider(provider);
    }
    //删除供应商
    @Override
    public int delProviderById(Integer id) {
        return providerDao.delProviderById(id);
    }
    //根据id查询供应商
    @Override
    public Provider findProviderById(Integer id) {
        return providerDao.findProviderById(id);
    }


}
