package com.atqgh.micro.security.service;

import com.atqgh.micro.acsApi.entity.MenuVo;

import java.util.List;

/**
 * @ProjectName: education-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/10/7 8:48
 */
public interface SecMenuService {

    List<MenuVo> getVoByParentId(Long parentId);
}
