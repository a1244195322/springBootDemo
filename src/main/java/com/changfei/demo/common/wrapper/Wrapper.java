package com.changfei.demo.common.wrapper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.changfei.demo.common.page.PageData;

import java.util.List;
import java.util.Map;

public interface Wrapper<T> extends IService<T> {
    List<T> getListByMap(Map<String, Object> params);
    PageData<T> getPageByMap(Map<String, Object> params);
}
