package com.zheshuo.advert.core.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javafx.util.Pair;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * created by zhanglong and since  2019/12/12  4:10 下午
 * @description: 描述
 */
@Slf4j
@Component
public class AdminLoginCache {

    public void register( String token) {
        adminLoginPool.put(token, System.currentTimeMillis() + 30 * 60000);
    }


    public void remove( String token ) {
        adminLoginPool.remove(token);
    }

    public AdminLoginCache() {
        Executors.newSingleThreadExecutor().execute(() -> {
            while (true) {
                adminLoginPool.forEach(( token, exp ) -> {
                    if (System.currentTimeMillis() >= exp) {
                        remove(token);
                    }
                });
                try {
                    if (adminLoginPool.isEmpty()) {
                        TimeUnit.SECONDS.sleep(60000L);
                    }
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            }
        });
    }

    private Map<String, Long> adminLoginPool = new ConcurrentHashMap<>();

    @Data
    public class SecurityUser{
        private Long id;

        /**
         *用户名
         */
        private String username;

        /**
         *密码
         */
        private String password;

        /**
         *状态
         */
        private Integer state;

        /**
         *用户类型
         */
        private Integer type;
    }


}
