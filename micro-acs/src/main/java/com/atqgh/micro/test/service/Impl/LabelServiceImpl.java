package com.atqgh.micro.test.service.Impl;

import com.atqgh.micro.acsApi.entity.Label;
import com.atqgh.micro.common.vo.Result;
import com.atqgh.micro.test.mapper.LabelMapper;
import com.atqgh.micro.test.service.ILabelService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: education-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2021/1/22 20:42
 */
@Service
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label> implements ILabelService {

    @Autowired
    private LabelMapper labelMapper;

    @Override
    public Result getList(Page<Label> pageParam, Label label) {

        // 构建查询条件
        Map<String,Long> map = new HashMap<>();
        map.put("current",(pageParam.getCurrent() -1) * pageParam.getSize());
        map.put("size",pageParam.getSize());
        // 获取list集合
        List<Label> labelList = labelMapper.getList(map,label);
        // 获取总条数
        Long total = labelMapper.getTotal(label);
        pageParam.setTotal(total);
        pageParam.setRecords(labelList);
        return Result.ok().data(pageParam);
    }


}
