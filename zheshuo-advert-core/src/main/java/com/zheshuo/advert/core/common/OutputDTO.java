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
public class OutputDTO<T> extends BaseDTO {

    private String code;

    private String msg;

    private T data;

    public OutputDTO<T> success(T data){
        this.code = success;
        this.msg = success;
        this.data = data;
        return this;
    }

    public OutputDTO<Void> success(){
        final OutputDTO<Void> outputDTO = new OutputDTO<>();
        outputDTO.code = success;
        outputDTO.msg = success;
        return outputDTO;
    }
    
    public OutputDTO<?> fail(){
        this.code = fail;
        this.msg = fail;
        return this;
    }

    public OutputDTO<T> fail(String msg){
        this.code = fail;
        this.msg = fail;
        return this;
    }
}