package com.zheshuo.advert.core.common;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * created by zhanglong and since  2019/12/12  10:58 上午
 *
 * @description: 描述
 */
public abstract class BaseController {
    @PostMapping("/upload")
    public String upload( MultipartFile multipartFile){
        String url = null;
        //上传逻辑
        return url;
    }
}
