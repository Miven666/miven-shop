package shop.content.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import shop.common.pojo.TbPanel;
import shop.common.pojo.TbPanelContent;

import java.util.List;

/**
 * 板块
 *
 * @author mingzhi.xie
 * @date 2019/4/13
 */

@Mapper
public interface PanelMapper {
    /**
     * 获取板块集合
     * @param tbPanel   板块
     * @param order     排序
     * @return 板块集合
     */
    List<TbPanel> selectPanel(@Param("tbPanel") TbPanel tbPanel, @Param("order") String order);

    /**
     * 获取板块详情集合
     * @param tbPanelContent    板块
     * @param order             排序
     * @return 板块详情集合
     */
    List<TbPanelContent> selectPanelContent(@Param("tbPanelContent") TbPanelContent tbPanelContent, @Param("order") String order);
}
