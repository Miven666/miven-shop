package shop.common.pojo;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

/**
 * 排序的、分页的商品
 *
 * @author mingzhi.xie
 * @since 2020/5/25 1.0
 */
@Getter
@Setter
public class GoodsSortPage extends SortPage {
    /**
     * 分类号
     */
    private Long cid;
    /**
     * 大于的价格
     */
    private int priceGt = -1;
    /**
     * 小于等于的价格
     */
    private int priceLte = -1;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
