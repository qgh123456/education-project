package com.atqgh.micro.acsApi.entity;

import lombok.Data;

import java.util.List;

/**
 * @ProjectName: education-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/10/5 19:24
 */
@Data
public class MenuVo extends Menu {

    List<Menu> subMenuList;
}
