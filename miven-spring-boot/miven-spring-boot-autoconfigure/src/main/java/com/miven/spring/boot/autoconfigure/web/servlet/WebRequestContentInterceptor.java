package com.miven.spring.boot.autoconfigure.web.servlet;

import com.miven.logging.WebRequestContent;
import com.miven.logging.WebRequestContentContextHolder;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Web请求内容拦截器
 * @author mingzhi.xie
 * @since 1.0
 */
public class WebRequestContentInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        WebRequestContent content = new WebRequestContent();
        content.setMapping(request.getRequestURI());
        content.setIp(request.getRemoteHost());
        WebRequestContentContextHolder.setWebRequestContent(content);
        return true;
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, ModelAndView modelAndView) {
        WebRequestContentContextHolder.restWebRequestContent();
    }
}
