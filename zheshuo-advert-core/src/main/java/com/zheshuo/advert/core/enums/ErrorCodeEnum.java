package com.zheshuo.advert.core.enums;

/**
 * created by zhanglong and since  2019/12/12  9:18 上午
 *
 * @description: 描述
 */
public enum ErrorCodeEnum {

    E00000(500, "未知异常");

    ErrorCodeEnum( int code, String msg ) {
        this.code = code;
        this.msg = msg;
    }

    private String msg;

    private int code;

    public String msg() {
        return msg;
    }

    public int code() {
        return code;
    }
}
