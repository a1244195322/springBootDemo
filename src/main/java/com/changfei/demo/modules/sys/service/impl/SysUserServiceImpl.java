package com.changfei.demo.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.changfei.demo.modules.sys.entity.SysUser;
import com.changfei.demo.modules.sys.mapper.SysUserMapper;
import com.changfei.demo.modules.sys.service.ISysUserService;
import com.changfei.demo.common.wrapper.impl.WrapperImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author changfei
 * @since 2020-11-05
 */
@Service
public class SysUserServiceImpl extends WrapperImpl<SysUserMapper, SysUser> implements ISysUserService {

  @Override
  public QueryWrapper<SysUser> getWrapper(Map< String, Object> params){
    String id= (String) params.get("id");

    QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
    wrapper.eq(StringUtils.isNotBlank(id),"id",id);
    return wrapper;
  }


}
