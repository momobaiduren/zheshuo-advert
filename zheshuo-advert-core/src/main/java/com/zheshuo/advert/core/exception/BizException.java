package com.zheshuo.advert.core.exception;

import com.zheshuo.advert.core.enums.ErrorCodeEnum;

/**
 * created by zhanglong and since  2019/12/12  9:15 上午
 *
 * @description: 描述
 */
public class BizException extends RuntimeException {
    private int code;

    public BizException() {
    }

    public BizException(String message) {
        super(message);
        this.code = ErrorCodeEnum.E00000.code();
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(int code, String message) {
        super(message);
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

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}