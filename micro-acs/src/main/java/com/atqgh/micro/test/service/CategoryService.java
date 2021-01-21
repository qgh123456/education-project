package com.atqgh.micro.test.service;

import com.atqgh.micro.acsApi.entity.Category;
import com.atqgh.micro.common.vo.Result;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Qiguohui
 * @since 2020-10-11
 */
public interface CategoryService extends IService<Category> {

    Result getList(Page<Category> pageParam, Category category);

}
