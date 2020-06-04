package shop.common.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 商品详情
 *
 * @author mingzhi.xie
 * @since 2020/5/26 1.0
 */
@Getter
@Setter
public class GoodsDetails extends Goods {
    /**
     * 售卖数量限制
     */
    private Long limitNum;
    /**
     * 商品详情介绍
     */
    private String detail;
    /**
     * 商品小图片
     */
    private List<?> productImageSmall;
}
