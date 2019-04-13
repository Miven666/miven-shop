package shop.content.service.impl;

import cn.miven.cloud.common.jedis.JedisClient;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.common.pojo.TbItem;
import shop.common.pojo.TbPanel;
import shop.common.pojo.TbPanelContent;
import shop.content.mapper.PanelContentMapper;
import shop.content.mapper.PanelMapper;
import shop.content.mapper.TbItemMapper;
import shop.content.properties.ProductProperties;
import shop.content.service.PanelService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author mingzhi.xie
 * @date 2019/4/13
 */
public class PanelServiceImpl implements PanelService {
    private final static Logger logger = LoggerFactory.getLogger(PanelServiceImpl.class);

    @Resource
    private ProductProperties productProperties;

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
        Optional<String> json = jedisClient.get(productProperties.getHome());
        if(json.isPresent()) {
            logger.info("读取了首页缓存");
            return JSONObject.parseArray(json.get(), TbPanel.class);
        }

        // 条件查询
        panels = panelMapper.select(new TbPanel(0, 1), "sort_order");
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

        // 把结果添加至缓存
        jedisClient.set(productProperties.getHome(), JSON.toJSONString(panels));
        logger.info("添加了首页缓存");

        return panels;
    }
}
