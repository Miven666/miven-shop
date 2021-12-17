package com.miven.spring.boot.autoconfigure.web.servlet;

import com.miven.logging.WebRequestContent;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Servlet;

import static org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type.SERVLET;

/**
 * servlet自动配置
 *
 * @author mingzhi.xie
 * @since 1.0
 */
@Configuration
@ConditionalOnClass({Servlet.class, HandlerInterceptor.class})
@ConditionalOnWebApplication(type = SERVLET)
public class ServletAutoConfiguration {


    @Configuration
    @ConditionalOnClass(WebRequestContent.class)
    static class WebRequestContentConfiguration implements WebMvcConfigurer {

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(webRequestContentInterceptor());
        }

        @Bean
        public HandlerInterceptor webRequestContentInterceptor() {
            return new WebRequestContentInterceptor();
        }
    }
}
