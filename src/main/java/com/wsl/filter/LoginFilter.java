package com.wsl.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.net.HttpResponse;
import com.wsl.domain.User;
import com.wsl.service.UserService;
import com.wsl.service.impl.UserServiceImpl;
import com.wsl.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义过滤器
 */
//@WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    private static final ObjectMapper mapper = new ObjectMapper();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginFilter----init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LoginFilter----doFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }
        if (!StringUtils.isEmpty(token)) {
            User user = UserServiceImpl.sessionMap.get(token);
            if (user != null) {
                filterChain.doFilter(request, response);
            }else{
                JsonData jsonData = JsonData.buildError("登陆失败，token无效",-2);
                String jsonStr = mapper.writeValueAsString(jsonData);
                renderJson(response,jsonStr);
            }
        } else {
            JsonData jsonData = JsonData.buildError("未登陆",-3);
            String jsonStr = mapper.writeValueAsString(jsonData);
            renderJson(response,jsonStr);
        }
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

    @Override
    public void destroy() {
        System.out.println("LoginFilter----destroy");
    }
}
