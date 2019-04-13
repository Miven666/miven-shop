package shop.content.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.common.pojo.TbPanelContent;
import shop.content.service.PanelContentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 面板内容控制器
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */

@RestController
public class PanelContentController {

    @Resource
    private PanelContentService panelContentService;

    @GetMapping("/nav")
    public List<TbPanelContent> getNavList() {
        return panelContentService.getNavList();
    }
}
