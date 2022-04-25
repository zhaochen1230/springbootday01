package com.hz.springbootday01.dao;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hz.springbootday01.entity.Provider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author suolong
 * @Date 2022/4/6 19:03
 * @Version 1.5
 */

/**
 * 根据id 查询供应商对象
 */

public interface ProviderDao{





    /**
     * 多条件组合查询
     * 翻页查询供应商信息
     * @param pyl  偏移量
     * @param page_size 每页显示条数
     * @return
     */
    public List<Provider> findProviderList(
            @Param("pyl") Integer pyl,
            @Param("page_size") Integer page_size,
            @Param("proName")String proName,
            @Param("proDesc")String proDesc
    );
    /**
     * 获得总条数
     * @return
     */
    public Integer findProviderListCount(
            @Param("proName") String proName,
            @Param("proDesc")String proDesc
    );
    /**
     * 添加供应商
     * @param provider
     * @return
     */
    public Integer AddProvider(Provider provider);

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
