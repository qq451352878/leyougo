package com.leyou.item.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.common.pojo.com.leyou.common.parameter.BrandQueryByPageParameter;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class BrandServiceImpl  implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageResult<Brand> queryBrandByPage(BrandQueryByPageParameter brandQueryByPageParameter) {

        /**
         * 1.分页
         */
        PageHelper.startPage (brandQueryByPageParameter.getPage ( ), brandQueryByPageParameter.getRows ( ));

        /**
         *  2.排序
         */
        Example example = new Example (Brand.class);
        if (StringUtils.isNotBlank (brandQueryByPageParameter.getSortBy ( ))) {
            example.setOrderByClause (brandQueryByPageParameter.getSortBy ( ) + (brandQueryByPageParameter.getDesc ( ) ? " DESC" : " ASC"));
        }
        /**
         * 3.查询
         */
        if (StringUtils.isNotBlank (brandQueryByPageParameter.getKey ( ))) {
            example.createCriteria ( ).orLike ("name", brandQueryByPageParameter.getKey ( ) + "%").orEqualTo ("letter", brandQueryByPageParameter.getKey ( ).toUpperCase ( ));
        }
        List<Brand> list = this.brandMapper.selectByExample (example);

        /**
         * 4.创建PageInfo
         */
        PageInfo<Brand> pageInfo = new PageInfo<> (list);
        /**
         * 5.返回分页结果
         */
        return new PageResult<> (pageInfo.getTotal ( ), pageInfo.getList ( ));
    }
}
