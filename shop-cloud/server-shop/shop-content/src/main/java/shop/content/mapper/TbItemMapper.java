package shop.content.mapper;

import org.apache.ibatis.annotations.Mapper;
import shop.common.pojo.GoodsSortPage;
import shop.common.pojo.TbItem;

import java.util.List;

/**
 * 商品
 *
 * @author mingzhi.xie
 * @date 2019/4/13
 */

@Mapper
public interface TbItemMapper {

    /**
     * 根据索引查询商品
     * @param id    板块Id
     * @return      TbItem
     */
    TbItem selectByIndex(Long id);

    /**
     * 根据价格范围查询商品
     */
    List<TbItem> selectItemsByPriceRange(GoodsSortPage goods);
}
