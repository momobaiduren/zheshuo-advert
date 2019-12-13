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
 * @description: 分布式放入redis或者其他服务中
 */
@Slf4j
@Component
public class AdminLoginCache {

    private Map<String, Pair<Long,SecurityUser>> adminLoginPool = new ConcurrentHashMap<>();

    public void register( String token, SecurityUser securityUser) {
        adminLoginPool.put(token, new Pair<>(System.currentTimeMillis() + 30 * 60000, securityUser));
    }

    public SecurityUser getUser( String token) {
        Pair<Long, SecurityUser> longSecurityUserPair = adminLoginPool.get(token);
        if (null == longSecurityUserPair){
            return null;
        }
        return longSecurityUserPair.getValue();
    }

    public void remove( String token ) {
        adminLoginPool.remove(token);
    }

    public AdminLoginCache() {
        Executors.newSingleThreadExecutor().execute(() -> {
            while (true) {
                adminLoginPool.forEach(( token, securityUserPair ) -> {
                    if (System.currentTimeMillis() >= securityUserPair.getKey()) {
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
