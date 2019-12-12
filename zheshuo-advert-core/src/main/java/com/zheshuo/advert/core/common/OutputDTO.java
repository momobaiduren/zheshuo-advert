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
        this.code = SUCCESS;
        this.msg = SUCCESS;
        this.data = data;
        return this;
    }

    public OutputDTO<Void> success(){
        final OutputDTO<Void> outputDTO = new OutputDTO<>();
        outputDTO.code = SUCCESS;
        outputDTO.msg = SUCCESS;
        return outputDTO;
    }
    
    public OutputDTO<?> fail(){
        this.code = FAIL;
        this.msg = FAIL;
        return this;
    }

    public OutputDTO<T> fail(String msg){
        this.code = FAIL;
        this.msg = msg;
        return this;
    }
}