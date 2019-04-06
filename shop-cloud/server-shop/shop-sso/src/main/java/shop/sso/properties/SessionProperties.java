package shop.sso.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 极验配置
 *
 * @author mingzhi.xie
 * @date 2019/4/5
 */

@Data
@Component
@ConfigurationProperties(prefix = "sso.session")
public class SessionProperties {
    /**
     * 过期时间，单位秒
     */
    private Integer expire;
}
