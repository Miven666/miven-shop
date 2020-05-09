package cn.miven.cloud.center.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mingzhi.xie
 * @date 2020/5/9
 * @since 1.0
 */
@Getter
@Setter
@ConfigurationProperties("eureka")
public class EurekaProperties {
    /**
     * 环境
     */
    private String environment;
    /**
     * 数据中心
     */
    private String datacenter;
}
