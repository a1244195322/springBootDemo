package com.changfei.demo.common.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <b>标题：</b> <br>
 * <b>描述：</b> <br>
 * <b>设计：</b> Administrator<br>
 * <b>创建：</b> 2020/11/4 15:32<br>
 * <b>更新：</b>时间： 更新人： 更新内容：<br>
 * <b>审查：</b>时间： 审查人： 审查情况：<br>
 * <b>抽查：</b>时间： 抽查人： 抽查情况：
 *
 * @author Administrator
 * @version 1.0
 */
@Data
public class PageData<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    @ApiModelProperty("总记录数")
    private long total;

    /**
     * 列表数据
     */
    @ApiModelProperty("列表数据")
    private List<T> list;

    /**
     * 分页
     * @param list   列表数据
     * @param total  总记录数
     */
    public PageData(List<T> list, long total) {
        this.list = list;
        this.total = total;
    }

}
