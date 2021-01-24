package com.atqgh.micro.test.service.Impl;

import com.atqgh.micro.acsApi.entity.Category;
import com.atqgh.micro.acsApi.entity.Label;
import com.atqgh.micro.common.vo.Result;
import com.atqgh.micro.test.mapper.CategoryMapper;
import com.atqgh.micro.test.mapper.LabelMapper;
import com.atqgh.micro.test.service.CategoryService;
import com.atqgh.micro.test.service.ILabelService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: education-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2021/1/22 20:42
 */
@Service
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label> implements ILabelService {

    @Override
    public Result getList(Page<Category> pageParam, Label label) {

        // 构建查询条件
        QueryWrapper<Label> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(label.getLabelName()),"label_name",label.getLabelName());
        return Result.ok().data(pageParam);
    }


}
