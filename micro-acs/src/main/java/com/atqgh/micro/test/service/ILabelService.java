package com.atqgh.micro.test.service;

import com.atqgh.micro.acsApi.entity.Category;
import com.atqgh.micro.acsApi.entity.Label;
import com.atqgh.micro.common.vo.Result;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ILabelService  extends IService<Label> {
    Result getList(Page<Category> pageParam, Label label);
}
