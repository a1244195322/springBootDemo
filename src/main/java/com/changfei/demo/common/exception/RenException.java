package com.changfei.demo.common.exception;

import com.changfei.demo.common.utils.MessageUtils;
import lombok.Data;

/**
 * <b>标题：</b> <br>
 * <b>描述：</b> <br>
 * <b>设计：</b> Administrator<br>
 * <b>创建：</b> 2020/11/12 11:35<br>
 * <b>更新：</b>时间： 更新人： 更新内容：<br>
 * <b>审查：</b>时间： 审查人： 审查情况：<br>
 * <b>抽查：</b>时间： 抽查人： 抽查情况：
 *
 * @author Administrator
 * @version 1.0
 */
@Data
public class RenException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

    public RenException(int code) {
        this.code = code;
        this.msg = MessageUtils.getMessage(code);
    }

    public RenException(int code, String... params) {
        this.code = code;
        this.msg = MessageUtils.getMessage(code, params);
    }

    public RenException(int code, Throwable e) {
        super(e);
        this.code = code;
        this.msg = MessageUtils.getMessage(code);
    }

    public RenException(int code, Throwable e, String... params) {
        super(e);
        this.code = code;
        this.msg = MessageUtils.getMessage(code, params);
    }

    public RenException(String msg) {
        super(msg);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = msg;
    }

    public RenException(String msg, Throwable e) {
        super(msg, e);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = msg;
    }
}
