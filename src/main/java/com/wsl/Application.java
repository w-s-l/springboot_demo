package com.wsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//开启组件扫描
@ServletComponentScan
//开启定时扫描
//@EnableScheduling
//开启异步
@EnableAsync
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
