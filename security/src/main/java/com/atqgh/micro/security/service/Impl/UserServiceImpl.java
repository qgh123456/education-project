package com.atqgh.micro.security.service.Impl;

import com.atqgh.micro.acsApi.entity.Menu;
import com.atqgh.micro.acsApi.entity.Role;
import com.atqgh.micro.acsApi.entity.User;
import com.atqgh.micro.security.mapper.SecRoleMapper;
import com.atqgh.micro.security.mapper.SecUserMapper;
import com.atqgh.micro.security.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @ProjectName: education-project
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/9/13 18:50
 */
@Service(value = "secUservice")
public class UserServiceImpl extends ServiceImpl<SecUserMapper, User> implements UserService {

    @Autowired
    @Qualifier(value = "secUserMapper")
    private SecUserMapper userMapper;

    @Autowired
    @Qualifier(value = "secRoleMapper")
    private SecRoleMapper roleMapper;

    @Override
    public User selectUserByName(String username) {
        // 构造查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",username);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public List<Role> selectRoleByUserId(Long userId) {

        List<Role> roles = roleMapper.selectRoleByUserId(userId);
        return roles;
    }

    @Override
    public List<Menu> selectPermissionByUserId(Long userId) {

        List<Menu> permissionList = userMapper.selectPermissionByUserId(userId);
        return permissionList;
    }


}
