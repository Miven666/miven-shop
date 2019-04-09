package shop.front.web.manager.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import shop.common.pojo.TbPanelContent;
import shop.front.web.manager.consumer.ContentConsumer;

import java.util.List;

/**
 *内容熔断
 *
 * @author mingzhi.xie
 * @date 2019/4/9.
 */

@Component
public class ContentHystrix implements ContentConsumer {
    private final static Logger logger = LoggerFactory.getLogger(ContentHystrix.class);

    @Override
    public List<TbPanelContent> getNavList() {
        logger.error("FeignClient shop-content getNavList is error.");
        return null;
    }
}
