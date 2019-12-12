package com.zheshuo.advert.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;

/**
 * 自定义demo表(AccountInfo)请求参数基类绑定分页参数
 * @author ZhangLong
 * @since 2019-12-11 18:42:27
 */

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;


@Data
public abstract class BaseRequest {

    private int current = 1;
    private int size = 10;

    public <T> Page<T> page() {
        return new Page<>(this.current, this.size);
    }

    public abstract <T> QueryWrapper<T> queryWrapper();
}