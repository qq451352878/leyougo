package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.common.pojo.com.leyou.common.parameter.BrandQueryByPageParameter;
import com.leyou.item.pojo.Brand;

public interface BrandService {

    /**
     * 分页查询
     * @param brandQueryByPageParameter
     * @return
     */
    PageResult<Brand> queryBrandByPage(BrandQueryByPageParameter brandQueryByPageParameter);
}
