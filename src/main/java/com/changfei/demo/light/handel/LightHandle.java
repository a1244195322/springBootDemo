package com.changfei.demo.light.handel;

import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;

public interface LightHandle{

    public TaskResult openLight(TaskQuery query);

}
