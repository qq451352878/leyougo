package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.common.pojo.com.leyou.common.parameter.BrandQueryByPageParameter;
import com.leyou.item.pojo.Brand;

import java.util.List;

public interface BrandService {

    /**
     * 分页查询
     * @param brandQueryByPageParameter
     * @return
     */
    PageResult<Brand> queryBrandByPage(BrandQueryByPageParameter brandQueryByPageParameter);

    /**
     * 分页查询
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */

    PageResult<Brand> queryBrandByPageAndSort(
            Integer page, Integer rows, String sortBy, Boolean desc, String key);

    /**
     * 品牌的新增
     * @param brand
     * @param cids
     */
    void saveBrand(Brand brand, List<Long> cids);

}
