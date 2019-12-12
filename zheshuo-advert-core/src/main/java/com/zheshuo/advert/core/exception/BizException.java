package com.zheshuo.advert.core.exception;

import com.zheshuo.advert.core.enums.ErrorCodeEnum;

/**
 * created by zhanglong and since  2019/12/12  9:15 上午
 * @description: 描述
 */
public class BizException extends RuntimeException {
    private int code;
    private String msg;

    public BizException() {
    }

    public BizException(String msg) {
        super(msg);
        this.msg = msg;
        this.code = ErrorCodeEnum.E00000.code();
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BizException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public BizException(int code, String messageFormat, Object... args) {
        super(String.format(messageFormat, args));
        this.code = code;
    }

    public BizException(ErrorCodeEnum codeEnum, Object... args) {
        super(String.format(codeEnum.msg(), args));
        this.code = codeEnum.code();
    }
}