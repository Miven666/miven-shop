package com.miven.logging;

import java.lang.annotation.*;

/**
 * 日志拦截注解
 * @author mingzhi.xie
 * @since 1.0
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Logging {
    /**
     * 日志级别，默认 INFO
     */
    Level level() default Level.INFO;
    /**
     * 模块名,例如：{@link Module.SpringModule#Controller}
     * @see Module
     */
    String module() default "";
}
