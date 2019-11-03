package shop.content.properties;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 商品首页配置
 * @author mingzhi.xie
 * @date 2019/4/7
 * @since 1.0
 */
@Data
@Component
public class GoodsHomeProperties {
    /**
     * 缓存key
     */
    private String key = "goods_home";
}
