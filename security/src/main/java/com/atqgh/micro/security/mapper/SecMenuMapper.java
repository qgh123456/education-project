package com.atqgh.micro.security.mapper;

import com.atqgh.micro.acsApi.entity.Menu;
import com.atqgh.micro.acsApi.entity.MenuVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

public interface SecMenuMapper extends BaseMapper<Menu> {

    List<MenuVo> getVoByParentId(Long parentId);


}
