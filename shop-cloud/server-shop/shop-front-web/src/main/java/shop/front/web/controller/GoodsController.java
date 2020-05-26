package shop.front.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import shop.common.pojo.*;
import shop.common.util.ResultUtils;
import shop.front.web.service.ContentService;

import javax.annotation.Resource;
import java.util.List;

import static shop.common.util.SortRule.ASC;
import static shop.common.util.SortRule.DESC;

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

    @ApiOperation("商品导航栏")
    @GetMapping("/goods/navList")
    public Result<List<TbPanelContent>> getNavList() {
        List<TbPanelContent> list = contentService.getNavList();
        return new ResultUtils<List<TbPanelContent>>().setData(list);
    }

    @ApiOperation("商品首页板块")
    @GetMapping("/goods/home")
    public Result<List<TbPanel>> getProductHome() {
        List<TbPanel> list = contentService.getHome();
        return new ResultUtils<List<TbPanel>>().setData(list);
    }

    @ApiOperation("商品推荐板块")
    @GetMapping("/goods/recommend")
    public Result<List<TbPanel>> getRecommendGoods() {
        List<TbPanel> list = contentService.getRecommendGoods();
        return new ResultUtils<List<TbPanel>>().setData(list);
    }

    @ApiOperation(value = "所有商品（分页）")
    @RequestMapping(value = "/goods/allGoods", method = RequestMethod.GET)
    public Result<DataPages> getGoodsPages(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "") String sort,
            @RequestParam(defaultValue = "") Long cid,
            @RequestParam(defaultValue = "-1") int priceGt,
            @RequestParam(defaultValue = "-1") int priceLte) {
        GoodsSortPage goods = new GoodsSortPage();
        goods.setCid(cid);
        goods.setPriceGt(priceGt);
        goods.setPriceLte(priceLte);
        goods.setPage(page <= 0 ? 1 : page);
        goods.setSize(size);

        if ("1".equals(sort)) {
            goods.setSortFeild("price");
            goods.setRule(ASC);
        } else if ("-1".equals(sort)) {
            goods.setSortFeild("price");
            goods.setRule(DESC);
        } else {
            goods.setSortFeild("created");
            goods.setRule(DESC);
        }
        DataPages goodsPagesResult = contentService.getGoodsPages(goods);
        return new ResultUtils<DataPages>().setData(goodsPagesResult);
    }
}
