package com.atqgh.micro.test.mapper;

import com.atqgh.micro.acsApi.entity.Label;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LabelMapper extends BaseMapper<Label> {

    List<Label> getList(@Param("pageParam") Map<String,Long> map, @Param("label") Label label);

    Long getTotal(@Param("label") Label label);
}
