package shop.content.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import shop.common.pojo.DataPages;
import shop.common.pojo.GoodsDetails;
import shop.common.pojo.GoodsSortPage;
import shop.content.service.GoodsService;

import javax.annotation.Resource;

/**
 * 商品控制器
 *
 * @author mingzhi.xie
 * @since 2020/5/25 1.0
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @ApiOperation("获取指定分页数的商品")
    @PostMapping("/page")
    public DataPages getPage(@RequestBody GoodsSortPage goods) {
        return goodsService.getPage(goods);
    }

    @ApiOperation("获取商品详情")
    @GetMapping("/details")
    public GoodsDetails getGoodsDetails(@RequestParam Long productId) {
        return goodsService.getDetails(productId);
    }
}
