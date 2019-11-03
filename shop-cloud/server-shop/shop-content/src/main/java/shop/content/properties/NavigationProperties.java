package shop.content.properties;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 导航栏配置
 * @author mingzhi.xie
 * @date 2019/4/7
 * @since 1.0
 */
@Data
@Component
public class NavigationProperties {
    /**
     * 表 ID
     */
    private int id = 0;
    /**
     * 缓存key
     */
    private String key = "panel_navigation";

}
