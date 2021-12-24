package com.miven.learning.context;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;

/**
 * @author xiemingzhi
 * @since 1.0
 */
public class PlainApplicationListener implements ApplicationListener<ApplicationEvent> {


    @Override
    public void onApplicationEvent(@NonNull ApplicationEvent event) {

    }
}
