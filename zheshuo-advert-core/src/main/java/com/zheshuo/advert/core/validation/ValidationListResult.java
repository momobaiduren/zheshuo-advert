package com.zheshuo.advert.core.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.EqualsAndHashCode;

import static java.util.stream.Collectors.joining;

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



