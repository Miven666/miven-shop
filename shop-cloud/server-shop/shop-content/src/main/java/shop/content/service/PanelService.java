package shop.content.service;

import shop.common.pojo.TbPanel;

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
}
