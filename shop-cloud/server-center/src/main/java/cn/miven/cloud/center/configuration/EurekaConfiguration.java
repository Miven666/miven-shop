package cn.miven.cloud.center.configuration;

import cn.miven.cloud.center.properties.EurekaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author mingzhi.xie
 * @date 2020/5/9
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(EurekaProperties.class)
public class EurekaConfiguration {
}
