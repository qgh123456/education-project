package com.atqgh.micro.test.mapper;

import com.atqgh.micro.acsApi.entity.Label;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

public interface LabelMapper extends BaseMapper<Label> {

    Page<Label> getList(@Param("pageParam") Page<Label> pageParam, @Param("label") Label label);
}
