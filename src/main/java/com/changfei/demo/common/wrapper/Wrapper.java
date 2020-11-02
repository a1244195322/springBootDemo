package com.changfei.demo.common.wrapper;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface Wrapper<T> extends IService<T> {
    List<T> getListByMap(Map<String, Object> params);
}
