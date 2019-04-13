package shop.content.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.common.pojo.TbPanel;
import shop.content.service.PanelService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 板块控制器
 *
 * @author mingzhi.xie
 * @date 2019/4/13
 */

@RestController
public class PanelController {

    @Resource
    private PanelService panelService;

    @GetMapping("/home")
    public List<TbPanel> getHome() {
        return panelService.getHome();
    }
}
