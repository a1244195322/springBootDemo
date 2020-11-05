package com.changfei.demo.common.wrapper.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changfei.demo.common.constant.Constant;
import com.changfei.demo.common.page.PageData;
import com.changfei.demo.common.wrapper.Wrapper;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public abstract class WrapperImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M,T> implements Wrapper<T> {

    public abstract QueryWrapper<T> getWrapper(Map<String, Object> params);

    @Override
    public List<T> getListByMap(Map<String, Object> params) {
        QueryWrapper<T> wrapper = getWrapper(params);
        return list(wrapper);
    }

    @Override
    public PageData<T> getPageByMap(Map<String, Object> params) {
        QueryWrapper<T> wrapper = getWrapper(params);
        IPage<T> page=page(getPage(params,"id",false),wrapper);
        return new PageData(page.getRecords(),page.getTotal());
    }

    /**
     *@描述
     *@param params             分页查询参数
     *@param defaultOrderField  默认排序字段
     *@param isAsc              排序方式
     *@返回值 com.baomidou.mybatisplus.core.metadata.IPage<T>
     *@创建人 changfei
     *@创建时间 2020/11/4 15:17
     *@修改人和其它信息
     */
    protected IPage<T> getPage(Map<String, Object> params, String defaultOrderField, boolean isAsc){
        long current= 1;
        long size= 10;
        if(params.get(Constant.PAGE_NO)!=null){
            current= Long.parseLong((String)params.get(Constant.PAGE_NO));
        }
        if(params.get(Constant.LIMIT)!=null){
            size= Long.parseLong((String)params.get(Constant.LIMIT));
        }
        Page page=new Page(current,size);
        //排序字段
        String orderField = (String)params.get(Constant.ORDER_FIELD);
        String order = (String)params.get(Constant.ORDER);

        //前端字段排序
        if(StringUtils.isNotBlank(orderField) && StringUtils.isNotBlank(order)){
            if(Constant.ASC.equalsIgnoreCase(order)) {
                return page.setAsc(orderField);
            }else {
                return page.setDesc(orderField);
            }
        }
        //默认排序
        if(isAsc) {
            page.setAsc(defaultOrderField);
        }else {
            page.setDesc(defaultOrderField);
        }
        return page;
    }
}
