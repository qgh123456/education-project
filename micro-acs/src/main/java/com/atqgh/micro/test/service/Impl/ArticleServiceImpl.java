package com.atqgh.micro.test.service.Impl;

import com.atqgh.micro.acsApi.entity.Article;
import com.atqgh.micro.acsApi.entity.Label;
import com.atqgh.micro.common.vo.Result;
import com.atqgh.micro.test.mapper.ArticleMapper;
import com.atqgh.micro.test.mapper.LabelMapper;
import com.atqgh.micro.test.service.ArticleService;
import com.atqgh.micro.test.service.ILabelService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: education-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2021/1/26 16:19
 */
@Service
public class ArticleServiceImpl  extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Result getList(Page<Article> pageParam, Article article) {

        // 构建查询条件
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(article.getTitle()),"title",article.getTitle());
        queryWrapper.eq(StringUtils.isNotEmpty(article.getStatus()),"status",article.getStatus());
        this.articleMapper.selectPage(pageParam,queryWrapper);
        return Result.ok().data(pageParam);
    }
}
