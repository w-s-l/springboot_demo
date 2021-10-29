package com.wsl.controller;

import com.wsl.task.AsyncTask;
import com.wsl.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/api/v1/pub/test")
public class TestController {

    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("testException")
    JsonData testException(){
        int i = 1/0;
        return JsonData.buildSuccess("");
    }
    @GetMapping("async")
    public JsonData testAsync(){
        long begin = System.currentTimeMillis();
//        asyncTask.task1();
//        asyncTask.task2();
//        asyncTask.task3();
        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();
        long end = System.currentTimeMillis();
        for(;;){
            if(task4.isDone()&&task5.isDone()){
                try {
                    String task4Result = task4.get();
                    String task5Result = task5.get();
                    System.out.println(task4Result);
                    System.out.println(task5Result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return JsonData.buildSuccess(end-begin);
    }

}
