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

    @PostMapping("/getList/{pageNo}/{pageSize}")
    public Result getList(@ApiParam(name = "pageNo", value = "当前页码", defaultValue = "1")
                              @PathVariable Long pageNo,
                          @ApiParam(name = "pageSize", value = "每页记录数", defaultValue = "20")
                              @PathVariable Long pageSize,
                          @ApiParam(name = "dataItemQuery", value = "查询对象", required = false)
                                      @RequestBody Label label){

        //封装分页
        Page<Label> pageParam = new Page<>(pageNo,pageSize);
        Result result = this.labelService.getList(pageParam,label);
        return result;
    }




}

