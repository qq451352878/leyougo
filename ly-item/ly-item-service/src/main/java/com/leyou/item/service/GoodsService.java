package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.common.pojo.com.leyou.common.parameter.SpuQueryByPageParameter;
import com.leyou.item.bo.SpuBo;

public interface GoodsService {

    /**
     * 分页查询
     * @param spuQueryByPageParameter
     * @return
     */
    public PageResult<SpuBo> querySpuByPageAndSort(SpuQueryByPageParameter spuQueryByPageParameter);
}
