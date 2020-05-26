package shop.content.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.common.pojo.DataPages;
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
}
