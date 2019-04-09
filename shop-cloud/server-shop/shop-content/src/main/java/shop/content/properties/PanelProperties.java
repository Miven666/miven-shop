package shop.content.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author mingzhi.xie
 * @date 2019/4/7
 */
@Data
@Component
@ConfigurationProperties(prefix = "panel")
public class PanelProperties {

    /**
     * 导航栏板块表id
     */
    private int id = 0;

    /**
     * 导航栏板块缓存key
     */
    private String header = "panel_header";
}
