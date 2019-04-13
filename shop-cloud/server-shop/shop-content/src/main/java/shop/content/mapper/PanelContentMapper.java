package shop.content.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import shop.common.pojo.TbPanelContent;

import java.util.List;

/**
 * @author mingzhi.xie
 * @date 2019/4/7
 */
@Mapper
public interface PanelContentMapper {

    /**
     * 获取导航栏
     * @param tbPanelContent    板块
     * @param order             排序
     * @return List<TbPanelContent>
     */
    List<TbPanelContent> select(@Param("tbPanelContent") TbPanelContent tbPanelContent, @Param("order") String order);
}
