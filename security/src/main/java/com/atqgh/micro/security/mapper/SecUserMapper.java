package com.atqgh.micro.security.mapper;

import com.atqgh.micro.acsApi.entity.Menu;
import com.atqgh.micro.acsApi.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Qiguohui
 * @since 2020-09-12
 */
public interface SecUserMapper extends BaseMapper<User> {

    List<Menu> selectPermissionByUserId(Long userId);
}

