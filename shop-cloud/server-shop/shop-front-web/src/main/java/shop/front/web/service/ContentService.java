package shop.front.web.service;

import shop.common.pojo.TbPanelContent;

import java.util.List;

/**
 * 内容
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */
public interface ContentService {
    /**
     * 获取导航栏
     * @return 导航栏
     */
    List<TbPanelContent> getNavList();
}
