package com.atqgh.micro.test.service;

import com.atqgh.micro.acsApi.entity.Article;
import com.atqgh.micro.common.vo.Result;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ArticleService  extends IService<Article> {

    Result getList(Page<Article> pageParam, Article article);
}
