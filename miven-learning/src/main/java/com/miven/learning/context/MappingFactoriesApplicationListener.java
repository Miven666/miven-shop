package com.miven.learning.context;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;

/**
 * 只有此种方式可以自动配置在 SpringApplication 中
 *
 * @author xiemingzhi
 * @since 1.0
 */
public class MappingFactoriesApplicationListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(@NonNull ApplicationEvent event) {

    }
}
