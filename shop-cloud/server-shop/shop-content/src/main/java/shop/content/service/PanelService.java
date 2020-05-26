package shop.content.service;

import shop.common.pojo.TbPanel;
import shop.common.pojo.TbPanelContent;

import java.util.List;

/**
 * 板块
 *
 * @author mingzhi.xie
 * @date 2019/4/13
 */
public interface PanelService {
    /**
     * 首页展示
     * @return 首页
     */
    List<TbPanel> getHome();

    /**
     * 推荐
     * @return 推荐
     */
    List<TbPanel> getRecommendGoods();

    /**
     * 获取导航栏
     * @return 导航栏
     */
    List<TbPanelContent> getNavList();
}
