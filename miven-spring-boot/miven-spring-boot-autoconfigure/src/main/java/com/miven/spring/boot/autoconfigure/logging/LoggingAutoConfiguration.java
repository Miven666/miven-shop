package com.miven.spring.boot.autoconfigure.logging;

import com.miven.logging.LogContent;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 日志自动配置类
 * @author mingzhi.xie
 * @since 1.0
 */
@Configuration
@ConditionalOnClass(LogContent.class)
@ConditionalOnProperty(prefix = "miven.spring.logging", name = "enabled", havingValue = "true", matchIfMissing = true)
public class LoggingAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MethodLogAdvisingPostProcessor methodLogAdvisingPostProcessor() {
        return new MethodLogAdvisingPostProcessor();
    }
}
