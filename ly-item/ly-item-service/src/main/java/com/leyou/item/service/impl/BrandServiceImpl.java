package com.leyou.item.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.common.pojo.com.leyou.common.parameter.BrandQueryByPageParameter;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class BrandServiceImpl  implements BrandService  {

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


    /**
     * 新增品牌
     * @param brand
     * @param cids
     */
    @Transactional
    @Override
    public void saveBrand(Brand brand, List<Long> cids) {
        //新增品牌
        brand.setId (null);
        int count= brandMapper.insert (brand);
        // 新增品牌和分类中间表
        for (Long cid :cids){
            this.brandMapper.insertCategoryBrand (cid, brand.getId ());
        }
    }

    public PageResult<Brand> queryBrandByPageAndSort(
            Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        // 开始分页
        PageHelper.startPage(page, rows);
        // 过滤
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().orLike("name", "%" + key + "%")
                    .orEqualTo("letter", key.toUpperCase ());
        }
        if (StringUtils.isNotBlank(sortBy)) {
            // 排序
            String orderByClause = sortBy + ( desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        // 查询
        Page<Brand> pageInfo = (Page<Brand>) brandMapper.selectByExample(example);
        // 返回结果
        return new PageResult<>(pageInfo.getTotal(), pageInfo);
    }
}
