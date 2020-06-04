package shop.front.web.remote.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import shop.common.pojo.*;
import shop.front.web.remote.ContentRemote;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容服务远程调用熔断
 *
 * @author mingzhi.xie
 * @date 2019/4/9.
 * @since 1.0
 */

@Component
public class ContentHystrix implements ContentRemote {
    private final static Logger logger = LoggerFactory.getLogger(ContentHystrix.class);

    @Override
    public List<TbPanelContent> getNavList() {
        logger.error("FeignClient shop-content getNavList is error.");
        return new ArrayList<>(0);
    }

    @Override
    public List<TbPanel> getHome() {
        logger.error("FeignClient shop-content getHome is error.");
        return new ArrayList<>(0);
    }

    @Override
    public List<TbPanel> getGoodsRecommend() {
        logger.error("FeignClient shop-content getRecommendGoods is error.");
        return new ArrayList<>(0);
    }

    @Override
    public DataPages getGoodsPages(GoodsSortPage goods) {
        logger.error("FeignClient shop-content getGoodsPages is error, Body parameters: {}", goods);
        DataPages pages = new DataPages();
        pages.setTotal(0);
        pages.setData(new ArrayList<>(0));
        return pages;
    }

    @Nullable
    @Override
    public GoodsDetails getGoodsDetails(Long productId) {
        logger.error("FeignClient shop-content getGoodsDetails is error, productId: {}", productId);
        return null;
    }
}
