package shop.content.mapper;

import org.apache.ibatis.annotations.Mapper;
import shop.common.pojo.TbPanelContent;
import shop.common.pojo.TbPanelContentExample;

import java.util.List;

/**
 * @author mingzhi.xie
 * @date 2019/4/7
 */
@Mapper
public interface PanelContentMapper {

    /**
     * 获取导航栏
     * @param exampleContent 样板
     * @return 导航栏
     */
    List<TbPanelContent> selectByExample(TbPanelContentExample exampleContent);
}
