package shop.content.service.impl;

import cn.miven.cloud.common.jedis.JedisClient;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import shop.common.pojo.TbItem;
import shop.common.pojo.TbPanel;
import shop.common.pojo.TbPanelContent;
import shop.content.mapper.PanelMapper;
import shop.content.mapper.TbItemMapper;
import shop.content.properties.GoodsHomeProperties;
import shop.content.properties.NavigationProperties;
import shop.content.properties.RecommendProperties;
import shop.content.service.PanelService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 板块
 *
 * @author mingzhi.xie
 * @date 2019/4/13
 */

@Service
public class PanelServiceImpl implements PanelService {
    private final static Logger logger = LoggerFactory.getLogger(PanelServiceImpl.class);
    @Resource
    private GoodsHomeProperties goodsHomeProperties;
    @Resource
    private RecommendProperties recommendProperties;
    @Resource
    private NavigationProperties navigationProperties;
    @Resource
    private JedisClient jedisClient;
    @Resource
    private PanelMapper panelMapper;
    @Resource
    private TbItemMapper tbItemMapper;


    @Override
    public List<TbPanel> getHome() {
        List<TbPanel> panels;
        // 有缓存则读取
        Optional<String> home = jedisClient.get(goodsHomeProperties.getKey());
        if(home.isPresent()) {
            logger.info("读取了首页缓存");
            return JSONObject.parseArray(home.get(), TbPanel.class);
        }
        // 条件查询
        panels = conditionSelect(new TbPanel(0, 1));
        // 把结果添加至缓存
        jedisClient.set(goodsHomeProperties.getKey(), JSON.toJSONString(panels));
        logger.info("添加了首页缓存");
        return panels;
    }

    @Override
    public List<TbPanel> getRecommendGoods() {
        List<TbPanel> panels;
        // 有缓存则读取
        Optional<String> recommend = jedisClient.get(recommendProperties.getKey());
        if(recommend.isPresent()) {
            logger.info("读取了推荐栏缓存");
            return JSONObject.parseArray(recommend.get(), TbPanel.class);
        }
        // 条件查询
        panels = conditionSelect(new TbPanel(recommendProperties.getId(), null, 1));
        // 把结果添加至缓存
        jedisClient.set(recommendProperties.getKey(), JSON.toJSONString(panels));
        logger.info("添加了推荐缓存");
        return panels;
    }

    @Override
    public List<TbPanelContent> getNavList() {
        List<TbPanelContent> list;
        // 有缓存则读取
        Optional<String> json = jedisClient.get(navigationProperties.getKey());
        if(json.isPresent()) {
            logger.info("读取了导航栏缓存");
            return JSONObject.parseArray(json.get(), TbPanelContent.class);
        }
        // 条件查询
        list = panelMapper.selectPanelContent(new TbPanelContent(navigationProperties.getId()), "sort_order");
        // 把结果添加至缓存
        jedisClient.set(navigationProperties.getKey(), JSON.toJSONString(list));
        logger.info("添加了导航栏缓存");

        return list;
    }

    private List<TbPanel> conditionSelect(TbPanel panel) {
        List<TbPanel> panels = panelMapper.selectPanel(panel, "sort_order");
        for (TbPanel tbPanel : panels) {
            List<TbPanelContent> contents = panelMapper.selectPanelContent(new TbPanelContent(tbPanel.getId()), "sort_order");
            for (TbPanelContent content : contents) {
                if (content.getProductId() != null) {
                    TbItem tbItem = tbItemMapper.selectByIndex(content.getProductId());
                    content.setProductName(tbItem.getTitle());
                    content.setSalePrice(tbItem.getPrice());
                    content.setSubTitle(tbItem.getSellPoint());
                }
            }
            tbPanel.setPanelContents(contents);
        }
        return panels;
    }
}
