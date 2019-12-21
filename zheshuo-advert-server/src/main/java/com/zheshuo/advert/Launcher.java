package com.zheshuo.advert;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Executors;


@SpringBootApplication
@MapperScan("com.zheshuo.advert.mapper")
public class Launcher {
    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
//        添加权限菜单
        Executors.newFixedThreadPool(1).execute(()->{

        });
    }

}
