package com.zheshuo.advert.core.common;

import java.util.List;
import lombok.Data;

/**
 * created by zhanglong and since  2019/12/11  11:27 上午
 *
 * @description: 描述
 */
@Data
public class PageData<T> {

    private long total;
    private long size;
    private long current;
    private List<T> list;
}
