package com.atqgh.micro.security.mapper;

import com.atqgh.micro.acsApi.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Qiguohui
 * @since 2020-09-12
 */
public interface SecRoleMapper extends BaseMapper<Role> {

    List<Role> selectRoleByUserId(Long userId);

}
