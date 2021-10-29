package com.wsl.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class videoOrderTask {
    //方法添加注解
    @Scheduled(fixedRate = 2000)//每两秒执行一次
    public void sum(){
        //正常从数据库中查询
        System.out.println(LocalDateTime.now()+"当前交易额="+Math.random());
    }
}
