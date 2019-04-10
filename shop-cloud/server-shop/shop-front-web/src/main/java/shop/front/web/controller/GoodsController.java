package shop.front.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.common.pojo.Result;
import shop.common.pojo.TbPanelContent;
import shop.common.util.ResultUtils;
import shop.front.web.service.ContentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品页面展示
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */
@RestController
public class GoodsController {

    @Resource
    private ContentService contentService;

    /**
     * 获取导航栏
     */
    @GetMapping("/goods/navList")
    public Result<List<TbPanelContent>> getNavList(){
        List<TbPanelContent> list = contentService.getNavList();
        return new ResultUtils<List<TbPanelContent>>().setData(list);
    }

    /**
     * 首页内容展示
     */
    @GetMapping("/goods/home")
    public Result<List<TbPanelContent>> getProductHome(){
        List<TbPanelContent> list = contentService.getHome();
        return new ResultUtils<List<TbPanelContent>>().setData(list);
    }
}
