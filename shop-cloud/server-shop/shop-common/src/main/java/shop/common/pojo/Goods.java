package shop.common.pojo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 商品
 *
 * @author mingzhi.xie
 * @since 2020/5/26 1.0
 */
@Getter
@Setter
public class Goods {
    /**
     * 商品ID
     */
    private Long productId;
    /**
     * 出售价格
     */
    private BigDecimal salePrice;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品副标题
     */
    private String subTitle;
    /**
     * 商品图片
     */
    private String productImageBig;
}
