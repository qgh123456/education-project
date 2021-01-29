package com.atqgh.micro.test.controller;

import com.atqgh.micro.acsApi.entity.Article;
import com.atqgh.micro.acsApi.entity.Category;
import com.atqgh.micro.common.vo.Result;
import com.atqgh.micro.test.service.ArticleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: education-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2021/1/26 16:22
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "分页列表")
    @PostMapping("/getList/{pageNo}/{pageSize}")
    public Result<Article> getList(@ApiParam(name = "pageNo", value = "当前页码", defaultValue = "1")
                                    @PathVariable Long pageNo,
                                   @ApiParam(name = "pageSize", value = "每页记录数", defaultValue = "20")
                                    @PathVariable Long pageSize,
                                   @ApiParam(name = "dataItemQuery", value = "查询对象", required = false)
                                            @RequestBody Article article){

        //封装分页
        Page<Article> pageParam = new Page<>(pageNo,pageSize);
        Result result = articleService.getList(pageParam,article);
        return result;
    }

}
