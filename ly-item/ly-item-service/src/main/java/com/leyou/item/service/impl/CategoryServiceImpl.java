package com.leyou.item.service.impl;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: 98050
 * Time: 2018-08-07 19:16
 * Feature: 分类的业务层
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<Category> queryCategoryByPid(Long pid) throws Exception {
        /**
         * 根据parentId查询子类目
         * @param pid
         * @return
         */
        Category record =new Category ();
        record.setParentId (pid);
        return this.categoryMapper.selectLast ();
    }

    @Override
    public List<Category> queryByBrandId(Long bid) {
        return null;
    }

    @Override
    public void saveCategory(Category category) {

    }

    @Override
    public void updateCategory(Category category) {

    }

    @Override
    public void deleteCategory(Long id) {

    }

    @Override
    public List<String> queryNameByIds(List<Long> asList) {
        return null;
    }

    @Override
    public List<Category> queryLast() {
        return null;
    }

    @Override
    public List<Category> queryCategoryByIds(List<Long> ids) {
        return null;
    }

    @Override
    public List<Category> queryAllCategoryLevelByCid3(Long id) {
        return null;
    }

    @Override
    public List<Category> queryCategoryListByParentId(Long pid) {
        return null;
    }
}
