package shop.content.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import shop.common.pojo.DataPages;
import shop.common.pojo.Goods;
import shop.common.pojo.GoodsSortPage;
import shop.common.pojo.TbItem;
import shop.content.mapper.TbItemMapper;
import shop.content.service.GoodsService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品服务
 *
 * @author mingzhi.xie
 * @since 2020/5/25
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private TbItemMapper tbItemMapper;

    @Override
    public DataPages getPage(GoodsSortPage goodsSortPage) {
        PageHelper.startPage(goodsSortPage.getPage(), goodsSortPage.getSize());
        List<TbItem> tbItemList = tbItemMapper.selectItemsByPriceRange(goodsSortPage);
        PageInfo<TbItem> pageInfo = PageInfo.of(tbItemList);
        List<TbItem> items = pageInfo.getList();
        ArrayList<Goods> goodsList = new ArrayList<>();
        for (TbItem item : items) {
            Goods goods = new Goods();
            goods.setProductId(item.getId());
            goods.setSalePrice(item.getPrice());
            goods.setProductName(item.getTitle());
            goods.setSubTitle(item.getSellPoint());
            goods.setProductImageBig(item.getImage()[0]);
            goodsList.add(goods);
        }
        DataPages dataPages = new DataPages();
        dataPages.setData(goodsList);
        dataPages.setTotal(pageInfo.getTotal());
        return dataPages;
    }
}
