package shop.content.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

/**
 * 板块配置
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 * @since 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "shop.content.panel")
public class PanelProperties {

    @NestedConfigurationProperty
    private NavigationProperties navigation;

    @NestedConfigurationProperty
    private RecommendProperties recommend;
}
