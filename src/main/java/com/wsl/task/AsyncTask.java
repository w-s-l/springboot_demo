package com.wsl.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import sun.net.www.protocol.file.FileURLConnection;

import java.util.concurrent.Future;

@Component
//异步注解
@Async
public class AsyncTask {
    public void task1() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task1");
    }

    public void task2() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task2");
    }

    public void task3() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task3");

    }
    //返回结果
    public Future<String> task4() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>("test4");
    }

    public Future<String> task5() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>("test5");
    }
}
