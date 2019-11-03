package shop.front.web.remote.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import shop.common.pojo.TbPanel;
import shop.common.pojo.TbPanelContent;
import shop.front.web.remote.ContentRemote;

import java.util.List;

/**
 *内容熔断
 *
 * @author mingzhi.xie
 * @date 2019/4/9.
 * @since 1.0
 */

@Component
public class ContentHystrix implements ContentRemote {
    private final static Logger logger = LoggerFactory.getLogger(ContentHystrix.class);

    @Nullable
    @Override
    public List<TbPanelContent> getNavList() {
        logger.error("FeignClient shop-content getNavList is error.");
        return null;
    }

    @Nullable
    @Override
    public List<TbPanel> getHome() {
        logger.error("FeignClient shop-content getHome is error.");
        return null;
    }

    @Nullable
    @Override
    public List<TbPanel> getRecommendGoods() {
        logger.error("FeignClient shop-content getRecommendGoods is error.");
        return null;
    }
}
