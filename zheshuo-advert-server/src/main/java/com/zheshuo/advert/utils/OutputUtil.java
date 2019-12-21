package com.zheshuo.advert.utils;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zheshuo.advert.core.common.OutputDTO;
import com.zheshuo.advert.core.common.PageData;
import com.zheshuo.advert.core.mapper.Mapper;
import java.util.List;
import java.util.ArrayList;
import org.apache.commons.collections.CollectionUtils;

/**
 * created by zhanglong and since  2019/12/11  11:54 上午
 * @description: 描述
 */
public class OutputUtil {

    public static <R, S> OutputDTO<PageData<R>> conveterPage( Class<R> rClass, Page<S> page ) {
        OutputDTO<PageData<R>> pageOutputDTO = new OutputDTO<>();
        final PageData<R> pageData = new PageData<>();
        if (CollectionUtils.isNotEmpty(page.getRecords())) {
            final List<R> responseList = Mapper.map(page.getRecords(), rClass);
            pageData.setCurrent(page.getCurrent());
            pageData.setList(responseList);
            pageData.setSize(page.getSize());
            pageData.setTotal(page.getTotal());
            pageOutputDTO.success(pageData);
        }else {
            pageOutputDTO.fail();
        }
        return pageOutputDTO;
    }

    public static <R, S> OutputDTO<R> conveter( Class<R> rClass, S t ) {
        OutputDTO<R> outputDTO = new OutputDTO<>();
        if (null != t) {
            R result = Mapper.map(t, rClass);
            outputDTO.success(result);
        }else {
            outputDTO.fail();
        }
        return outputDTO;
    }

    public static <R, S> OutputDTO<List<R>> conveterList( Class<R> rClass, List<S> sList ) {
        OutputDTO<List<R>> outputDTO = new OutputDTO<>();
        if (CollectionUtils.isNotEmpty(sList)) {
            List<R> rList = Mapper.map(sList, rClass);
            outputDTO.success(rList);
        }else {
            outputDTO.fail();
        }
        return outputDTO;
    }

}