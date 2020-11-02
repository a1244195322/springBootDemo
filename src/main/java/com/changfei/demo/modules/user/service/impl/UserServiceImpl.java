package com.changfei.demo.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.changfei.demo.common.wrapper.impl.WrapperImpl;
import com.changfei.demo.modules.user.entity.User;
import com.changfei.demo.modules.user.mapper.UserMapper;
import com.changfei.demo.modules.user.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author changfei
 * @since 2020-10-31
 */
@Service
public class UserServiceImpl extends WrapperImpl<UserMapper, User> implements IUserService {

    @Override
    public QueryWrapper<User> getWrapper(Map<String, Object> params){
        String name= (String) params.get("name");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(name),"name",name);
        return wrapper;
    }
}
