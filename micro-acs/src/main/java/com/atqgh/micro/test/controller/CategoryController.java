package com.atqgh.micro.test.controller;


import com.atqgh.micro.acs.annotation.OpLog;
import com.atqgh.micro.acsApi.entity.Category;
import com.atqgh.micro.common.vo.Result;
import com.atqgh.micro.test.service.CategoryService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Qiguohui
 * @since 2020-10-11
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "分页列表")
    @PostMapping("/getList/{pageNo}/{pageSize}")
    public Result<Category> getList(@ApiParam(name = "pageNo", value = "当前页码", defaultValue = "1")
                                    @PathVariable Long pageNo,
                                     @ApiParam(name = "pageSize", value = "每页记录数", defaultValue = "20")
                                    @PathVariable Long pageSize,
                                    @ApiParam(name = "dataItemQuery", value = "查询对象", required = false)
                                    Category category){

        //封装分页
        Page<Category> pageParam = new Page<>(pageNo,pageSize);
        Result result = categoryService.getList(pageParam,category);
        return result;
    }

    @ApiOperation(value = "新增分类")
    @PostMapping("/saveCategory")
    public Result<Category> saveCategory(@ApiParam(name = "dataItemData", value = "新增对象", required = true)
                                         @RequestBody Category category){

        // 新增
        categoryService.save(category);
        return Result.ok().message("新增成功");
    }

    @ApiOperation(value = "删除分类")
    @DeleteMapping("/deleteCategory/{id}")
    public Result<Category> deleteCategory(@ApiParam(name = "id", value = "主键", required = true)
                                           @PathVariable(value = "id") Long id){

        // 删除
        categoryService.removeById(id);
        return Result.ok().message("删除成功");
    }

    @ApiOperation(value = "修改分类")
    @PutMapping("/updateCategory")
    public Result<Category> updateCategory(@ApiParam(name = "dataItemData", value = "新增对象", required = true)
                                           @RequestBody Category category){

        // 修改
        categoryService.updateById(category);
        return Result.ok().message("修改成功");
    }

    @ApiOperation(value = "分类详情")
    @GetMapping("/getCategoryDetail/{id}")
    public Result<Category> getCategoryDetail(@ApiParam(name = "dataItemData", value = "新增对象", required = true)
                                           @PathVariable(value = "id") Long id){

        // 查询详情
        Category category = categoryService.getById(id);

        return Result.ok().data(category);
    }

    @RequestMapping("/a")
    @OpLog
    public String a(){
        String str = null;
        str.substring(0);
        return "ssss";
    }

}

