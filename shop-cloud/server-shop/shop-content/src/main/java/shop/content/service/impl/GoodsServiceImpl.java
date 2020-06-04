package shop.content.service.impl;

import cn.miven.cloud.common.jedis.JedisClient;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shop.common.pojo.*;
import shop.common.pojo.po.Item;
import shop.common.pojo.po.ItemDesc;
import shop.content.mapper.ItemDescMapper;
import shop.content.mapper.ItemMapper;
import shop.content.service.GoodsService;

import javax.annotation.Resource;
import java.util.*;

import static shop.content.config.ShopContentRedisKey.GOODS_DETAILS;
import static shop.content.config.ShopContentRedisKey.GOODS_DETAILS_EXPIRE;

/**
 * 商品服务
 *
 * @author mingzhi.xie
 * @since 2020/5/25
 */
@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private JedisClient jedisClient;
    @Resource
    private ItemMapper itemMapper;
    @Resource
    private ItemDescMapper itemDescMapper;

    @Override
    public DataPages getPage(GoodsSortPage goodsSortPage) {
        PageHelper.startPage(goodsSortPage.getPage(), goodsSortPage.getSize());
        List<Item> itemList = itemMapper.selectItemsByPriceRange(goodsSortPage);
        PageInfo<Item> pageInfo = PageInfo.of(itemList);
        List<Item> items = pageInfo.getList();
        ArrayList<Goods> goodsList = new ArrayList<>();
        for (Item item : items) {
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

    @Override
    public GoodsDetails getDetails(Long productId) {
        GoodsDetails details = new GoodsDetails();
        // 有缓存则读取
        Optional<String> json = jedisClient.get(GOODS_DETAILS + productId);
        if (json.isPresent()) {
            log.debug("读取商品编号'{}'的详情信息缓存: {}", productId, json.get());
            return JSONObject.parseObject(json.get(), GoodsDetails.class);
        }

        // 条件查询
        Item item = itemMapper.selectByIndex(productId);
        if (item == null) {
            log.warn("根据商品编号'{}'，通过Item(商品表)查询商品详情时，未找到任何信息", productId);
            return details;
        }
        if (item.getLimitNum() != null && !item.getLimitNum().toString().isEmpty()) {
            details.setLimitNum(Long.valueOf(item.getLimitNum()));
        } else {
            details.setLimitNum(Long.valueOf(item.getNum()));
        }
        String[] images = item.getImage();
        if (images != null && images.length != 0) {
            details.setProductImageBig(images[0]);
            List<String> list = new ArrayList<>();
            Collections.addAll(list, images);
            details.setProductImageSmall(list);
        }
        details.setProductId(productId);
        details.setProductName(item.getTitle());
        details.setSubTitle(item.getSellPoint());
        details.setSalePrice(item.getPrice());

        ItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(productId);
        if (itemDesc == null) {
            log.warn("根据商品编号'{}'，通过ItemDesc(商品详情表)查询商品详情时，未找到任何信息", productId);
            return details;
        }
        details.setDetail(itemDesc.getItemDesc());

        // 把结果添加至缓存
        String detailsJSON = JSON.toJSONString(details);
        jedisClient.set(GOODS_DETAILS + productId, detailsJSON, GOODS_DETAILS_EXPIRE);
        log.debug("添加商品编号'{}'的详情信息缓存: {}", productId, detailsJSON);

        return details;
    }
}
