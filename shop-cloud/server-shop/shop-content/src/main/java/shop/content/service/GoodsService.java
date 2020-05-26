package shop.content.service;

import shop.common.pojo.DataPages;
import shop.common.pojo.GoodsSortPage;

/**
 * @author mingzhi.xie
 * @since 2020/5/25
 */
public interface GoodsService {

    /**
     * 获取指定分页数的商品
     * @param goods 排序的、分页的商品
     * @return 指定分页数的商品
     */
    DataPages getPage(GoodsSortPage goods);
}
