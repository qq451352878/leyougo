package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface BrandMapper extends Mapper<Brand>, SelectByIdListMapper<Brand,Long> {

}
