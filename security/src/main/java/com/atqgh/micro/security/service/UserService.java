package com.atqgh.micro.security.service;

import com.atqgh.micro.acsApi.entity.Menu;
import com.atqgh.micro.acsApi.entity.Role;
import com.atqgh.micro.acsApi.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Qiguohui
 * @since 2020-09-12
 */
public interface UserService extends IService<User> {

    User selectUserByName(String username);

    List<Role> selectRoleByUserId(Long userId);

    List<Menu> selectPermissionByUserId(Long userId);
}
