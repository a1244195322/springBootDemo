package com.changfei.demo.common.exception;

/**
 * <b>标题：</b> <br>
 * <b>描述：</b> <br>
 * <b>设计：</b> Administrator<br>
 * <b>创建：</b> 2020/11/4 16:16<br>
 * <b>更新：</b>时间： 更新人： 更新内容：<br>
 * <b>审查：</b>时间： 审查人： 审查情况：<br>
 * <b>抽查：</b>时间： 抽查人： 抽查情况：
 *
 * @author Administrator
 * @version 1.0
 */
public interface ErrorCode {
    int INTERNAL_SERVER_ERROR = 500;
    int UNAUTHORIZED = 401;
    int FORBIDDEN = 403;
    int PAGENOTFOUND = 404;
}
