package com.atqgh.micro.test.controller;


import com.atqgh.micro.acsApi.entity.Category;
import com.atqgh.micro.acsApi.entity.Label;
import com.atqgh.micro.common.vo.Result;
import com.atqgh.micro.test.service.CategoryService;
import com.atqgh.micro.test.service.ILabelService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Qiguohui
 * @since 2020-10-11
 */
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private ILabelService labelService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "查询分类")
    @PostMapping("/getList/{pageNo}/{pageSize}")
    public Result getList(@ApiParam(name = "pageNo", value = "当前页码", defaultValue = "1")
                              @PathVariable(value = "pageNo") Long current,
                          @ApiParam(name = "pageSize", value = "每页记录数", defaultValue = "20")
                              @PathVariable(value = "pageSize") Long size,
                          @ApiParam(name = "dataItemQuery", value = "查询对象", required = false)
                                      @RequestBody Label label){

        //封装分页
        Page<Label> pageParam = new Page<>(current,size);
        Result result = this.labelService.getList(pageParam,label);
        return result;
    }


    @ApiOperation(value = "新增分类")
    @PostMapping("/saveLabel")
    public Result<Category> saveLabel(@ApiParam(name = "label", value = "新增对象", required = true)
                                         @RequestBody Label label){

        // 通过分类id获取分类名称
        Category category = categoryService.getById(label.getCategoryId());
        label.setCategoryName(category.getName());
        // 新增
        labelService.save(label);
        return Result.ok().message("新增成功");
    }

    @ApiOperation(value = "详情")
    @GetMapping("/selectLabelById")
    public Result<Label> selectLabelById(@RequestParam(value = "id")String id){

        Label label = labelService.getById(id);
        return Result.ok().data(label);
    }

    @ApiOperation(value = "删除标签")
    @DeleteMapping("/deleteLabel")
    public Result deleteLabel(@RequestParam(value = "id") String id){

        labelService.deleteLabel(id);
        return Result.ok().message("删除成功");
    }

    @ApiOperation(value = "修改标签")
    @PutMapping("/updateLabel")
    public Result<Label> updateLabel(@RequestBody Label label){

        // 获取修改的主键
        labelService.updateById(label);
        return Result.ok();
    }

}

