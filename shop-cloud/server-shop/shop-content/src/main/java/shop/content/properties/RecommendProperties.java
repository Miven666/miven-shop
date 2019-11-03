package shop.content.properties;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author mingzhi.xie
 * @date 2019/4/7
 * @since 1.0
 */
@Data
@Component
public class RecommendProperties {
    /**
     * 表 ID
     */
    private int id = 6;
    /**
     * 缓存key
     */
    private String key = "panel_recommend";
}
