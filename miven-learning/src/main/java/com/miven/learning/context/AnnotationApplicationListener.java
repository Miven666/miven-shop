package com.miven.learning.context;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

/**
 * @author xiemingzhi
 * @since 1.0
 */
@Configuration
public class AnnotationApplicationListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(@NonNull ApplicationEvent event) {

    }
}
