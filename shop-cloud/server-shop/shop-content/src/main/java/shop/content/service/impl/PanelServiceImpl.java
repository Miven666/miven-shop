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
import shop.content.mapper.PanelContentMapper;
import shop.content.mapper.PanelMapper;
import shop.content.mapper.TbItemMapper;
import shop.content.properties.GoodsHomeProperties;
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
    private JedisClient jedisClient;

    @Resource
    private PanelMapper panelMapper;

    @Resource
    private PanelContentMapper panelContentMapper;

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

        // 条件查询
        panels = conditionSelect(new TbPanel(recommendProperties.getId(), null, 1));
        // 把结果添加至缓存
        jedisClient.set(recommendProperties.getKey(), JSON.toJSONString(panels));
        logger.info("添加了推荐缓存");
        return panels;
    }

    private List<TbPanel> conditionSelect(TbPanel panel) {
        List<TbPanel> panels = panelMapper.select(panel, "sort_order");
        for (TbPanel tbPanel : panels) {
            List<TbPanelContent> contents = panelContentMapper.select(new TbPanelContent(tbPanel.getId()), "sort_order");
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
