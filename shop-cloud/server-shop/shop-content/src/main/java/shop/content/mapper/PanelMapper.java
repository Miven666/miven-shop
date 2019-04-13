package shop.content.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import shop.common.pojo.TbPanel;

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
     * 板块集合
     * @param tbPanel   板块
     * @param order     板块
     * @return List<TbPanel>
     */
    List<TbPanel> select(@Param("tbPanel") TbPanel tbPanel, @Param("order") String order);
}
