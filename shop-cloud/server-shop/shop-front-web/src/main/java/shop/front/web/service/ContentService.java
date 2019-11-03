package shop.front.web.service;

import shop.common.pojo.TbPanel;
import shop.common.pojo.TbPanelContent;

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
     * @return 导航栏
     */
    List<TbPanelContent> getNavList();

    /**
     * 首页内容展示
     * @return 首页内容
     */
    List<TbPanel> getHome();

    /**
     * 获取推荐商品
     * @return 推荐商品集合
     */
    List<TbPanel> getRecommendGoods();
}
