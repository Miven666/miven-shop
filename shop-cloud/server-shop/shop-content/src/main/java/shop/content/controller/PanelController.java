package shop.content.controller;

import io.swagger.annotations.ApiOperation;
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
 * @since 1.0
 */

@RestController
public class PanelController {

    @Resource
    private PanelService panelService;

    @ApiOperation("首页")
    @GetMapping("/home")
    public List<TbPanel> getHome() {
        return panelService.getHome();
    }

    @ApiOperation("推荐")
    @GetMapping("/recommend")
    public List<TbPanel> getRecommendGoods() {
        return panelService.getRecommendGoods();
    }
}
