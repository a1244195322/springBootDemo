package com.changfei.demo.light.handel.impl;

import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.changfei.demo.light.handel.LightHandle;
import org.springframework.stereotype.Component;

@Component
public class LightHandleImpl implements LightHandle {

    @Override
    public TaskResult openLight(TaskQuery query) {
        TaskResult result=new TaskResult();
        result.setReply("暂无服务");
        return result;
    }
}
