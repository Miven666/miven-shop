package shop.content.service;

import shop.common.pojo.TbPanelContent;

import java.util.List;

/**
 * 面板内容
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */
public interface PanelContentService {
    /**
     * 获取导航栏
     * @return 导航栏
     */
    List<TbPanelContent> getNavList();
}
