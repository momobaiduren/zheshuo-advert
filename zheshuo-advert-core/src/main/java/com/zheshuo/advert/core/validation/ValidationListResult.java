package com.zheshuo.advert.core.validation;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhanglong
 * @description: 描述
 * @date 2019-08-3113:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ValidationListResult<T> extends ValidationResult {

    private List<T> successData = new ArrayList<>();

    private Map<T, Map<String, String>> errorData = new HashMap<>();

    public List<T> get() {
        return successData;
    }


}



