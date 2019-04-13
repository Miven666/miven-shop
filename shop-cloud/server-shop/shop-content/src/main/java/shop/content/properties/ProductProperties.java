package shop.content.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 商品配置
 *
 * @author mingzhi.xie
 * @date 2019/4/13
 */

@Data
@Component
@ConfigurationProperties(prefix = "product")
public class ProductProperties {
    /**
     *商城首页缓存key
     */
    private String home = "product_home";
}
