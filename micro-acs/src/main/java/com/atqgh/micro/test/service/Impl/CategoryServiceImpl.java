package com.atqgh.micro.test.service.Impl;

import com.atqgh.micro.acsApi.entity.Category;
import com.atqgh.micro.common.vo.Result;
import com.atqgh.micro.test.mapper.CategoryMapper;
import com.atqgh.micro.test.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Qiguohui
 * @since 2020-10-11
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Result getList(Page<Category> pageParam, Category category) {

        // 构建查询条件
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(category.getName()),"name",category.getName());
        queryWrapper.eq(Objects.nonNull(category.getStatus()),"status",category.getStatus());
        categoryMapper.selectPage(pageParam,queryWrapper);
        return Result.ok().data(pageParam);

    }

    @Override
    public List<Category> getListCategory(String categoryName) {

        // 构建查询条件
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(categoryName),"name",categoryName);
        List<Category> categories = categoryMapper.selectList(queryWrapper);
        return categories;
    }

}
