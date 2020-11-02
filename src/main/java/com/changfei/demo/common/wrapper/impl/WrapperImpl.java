package com.changfei.demo.common.wrapper.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changfei.demo.common.wrapper.Wrapper;

import java.util.List;
import java.util.Map;

public abstract class WrapperImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M,T> implements Wrapper<T> {

    public abstract QueryWrapper<T> getWrapper(Map<String, Object> params);

    @Override
    public List<T> getListByMap(Map<String, Object> params) {
        QueryWrapper<T> wrapper = getWrapper(params);
        return list(wrapper);
    }
}
