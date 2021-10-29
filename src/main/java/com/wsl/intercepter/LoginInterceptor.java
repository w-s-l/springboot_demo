package com.wsl.intercepter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsl.domain.User;
import com.wsl.service.impl.UserServiceImpl;
import com.wsl.utils.JsonData;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterceptor--preHandle");


        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }
        if (!StringUtils.isEmpty(token)) {
            User user = UserServiceImpl.sessionMap.get(token);
            if (user != null) {
                return true;
            }else{
                JsonData jsonData = JsonData.buildError("登陆失败，token无效",-2);
                String jsonStr = mapper.writeValueAsString(jsonData);
                renderJson(response,jsonStr);
                return false;
            }
        } else {
            JsonData jsonData = JsonData.buildError("未登陆",-3);
            String jsonStr = mapper.writeValueAsString(jsonData);
            renderJson(response,jsonStr);
            return false;
        }


        //return HandlerInterceptor.super.preHandle(request,response,handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor--postHandle");
        HandlerInterceptor.super.postHandle(request,response,handler,modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginInterceptor--afterCompletion");
        HandlerInterceptor.super.afterCompletion(request,response,handler,ex);
    }


    private void renderJson(HttpServletResponse response,String json){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try(PrintWriter printWriter = response.getWriter()){
            printWriter.print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
