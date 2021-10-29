package com.wsl.handler;

import com.wsl.utils.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 标记这个是一个异常处理类
 */
@ControllerAdvice
//@RestControllerAdvice
public class CustomExtHandler {
    //处理异常类型，这里是Exception最大的异常（处理所有）
//    @ExceptionHandler(value = Exception.class)
//    JsonData handlerException(Exception e, HttpServletRequest request){
//        return JsonData.buildError("服务器出问题了！",-2);
//    }

    //自定义异常也页面并返回
    @ExceptionHandler(value = Exception.class)
    Object handlerException(Exception e, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        modelAndView.addObject("msg",e.getMessage());
        return modelAndView;
    }
}
