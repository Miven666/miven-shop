package shop.front.web.properties;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 极验配置
 *
 * @author mingzhi.xie
 * @date 2019/4/5
 */

@Data
@Getter
@Component
@ConfigurationProperties(prefix = "geetest")
public class GeetestProperties {
    /**
     * 公钥
     */
    private String captchaId;
    /**
     * 私钥
     */
    private String privateKey;
    /**
     * 是否开启新的failBack
     */
    private boolean newFailBack = true;
}
