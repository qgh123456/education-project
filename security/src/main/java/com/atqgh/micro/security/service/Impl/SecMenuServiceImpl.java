package com.atqgh.micro.security.service.Impl;

import com.atqgh.micro.acsApi.entity.MenuVo;
import com.atqgh.micro.security.mapper.SecMenuMapper;
import com.atqgh.micro.security.service.SecMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: education-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/10/7 8:49
 */
@Service
public class SecMenuServiceImpl implements SecMenuService {

    @Autowired
    private SecMenuMapper secMenuMapper;

    @Override
    public List<MenuVo> getVoByParentId(Long parentId) {
        return secMenuMapper.getVoByParentId(parentId);
    }
}
