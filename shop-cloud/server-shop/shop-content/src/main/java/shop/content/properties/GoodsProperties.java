package shop.content.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * 商品配置
 *
 * @author mingzhi.xie
 * @date 2019/4/13
 */

@Data
@Component
@ConfigurationProperties(prefix = "goods")
public class GoodsProperties {
    /**
     *商城首页缓存key
     */
    @NestedConfigurationProperty
    private GoodsHomeProperties home;
}
