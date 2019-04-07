package shop.front.web.manager.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import shop.common.pojo.TbPanelContent;

import java.util.List;

/**
 * 内容
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */
public interface ContentConsumer {

    /**
     * 获取导航栏
     * @return 导航栏
     */
    @GetMapping("/nav")
    List<TbPanelContent> getNavList();
}
