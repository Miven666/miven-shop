package shop.front.web.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.common.pojo.*;
import shop.front.web.remote.hystrix.ContentHystrix;

import java.util.List;

/**
 * 内容
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 * @since 1.0
 */

@FeignClient(value = "shop-content", fallback = ContentHystrix.class)
public interface ContentRemote {

    /**
     * 获取导航栏
     */
    @GetMapping("/nav")
    List<TbPanelContent> getNavList();

    /**
     * 首页内容展示
     */
    @GetMapping("/home")
    List<TbPanel> getHome();

    /**
     * 获取推荐商品
     */
    @GetMapping("/recommend")
    List<TbPanel> getGoodsRecommend();

    /**
     * 获取指定分页数的商品集合
     */
    @PostMapping("/goods/page")
    DataPages getGoodsPages(GoodsSortPage goods);

    /**
     * 获取商品详情
     */
    @GetMapping("/goods/details")
    GoodsDetails getGoodsDetails(@RequestParam Long productId);
}
