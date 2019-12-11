package com.zheshuo.advert.core.common;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * created by zhanglong and since  2019/12/11  10:54 上午
 * @author mymac
 * @description: 描述
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class PageOutputDTO<T> extends BaseDTO {

    private String code;

    private String msg;

    private PageData<T> pageData;


    public PageOutputDTO<T> success(PageData<T> pageData){
        this.code = success;
        this.msg = success;
        this.pageData = pageData;
        return this;
    }
    
    public PageOutputDTO<T> fail(){
        this.code = fail;
        this.msg = fail;
        return this;
    }

    public PageOutputDTO<T> fail(String msg){
        this.code = fail;
        this.msg = fail;
        return this;
    }
}