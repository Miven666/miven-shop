package shop.front.web.service;

import shop.common.pojo.GoodsSortPage;
import shop.common.pojo.TbPanel;
import shop.common.pojo.TbPanelContent;
import shop.common.pojo.DataPages;

import java.util.List;

/**
 * 内容
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 * @since 1.0
 */
public interface ContentService {
    /**
     * 获取导航栏
     */
    List<TbPanelContent> getNavList();

    /**
     * 首页内容展示
     */
    List<TbPanel> getHome();

    /**
     * 获取推荐商品
     */
    List<TbPanel> getRecommendGoods();

    /**
     * 获取所有商品（分页）
     */
    DataPages getGoodsPages(GoodsSortPage goods);
}
