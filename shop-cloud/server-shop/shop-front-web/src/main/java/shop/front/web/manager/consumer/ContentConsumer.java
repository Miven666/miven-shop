package shop.front.web.manager.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import shop.common.pojo.TbPanel;
import shop.common.pojo.TbPanelContent;
import shop.front.web.manager.hystrix.ContentHystrix;

import java.util.List;

/**
 * 内容
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */

@FeignClient(value = "shop-content", fallback = ContentHystrix.class)
public interface ContentConsumer {

    /**
     * 获取导航栏
     * @return 导航栏
     */
    @GetMapping("/nav")
    List<TbPanelContent> getNavList();

    /**
     * 首页内容展示
     * @return 首页内容
     */
    List<TbPanel> getHome();
}
