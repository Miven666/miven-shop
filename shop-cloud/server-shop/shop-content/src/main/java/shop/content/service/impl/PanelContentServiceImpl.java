package shop.content.service.impl;

import cn.miven.cloud.common.jedis.JedisClient;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import shop.common.pojo.Criteria;
import shop.common.pojo.TbPanelContent;
import shop.common.pojo.TbPanelContentExample;
import shop.content.mapper.PanelContentMapper;
import shop.content.properties.PanelProperties;
import shop.content.service.PanelContentService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 面板内容
 *
 * @author mingzhi.xie
 * @date 2019/4/7
 */
@Service
public class PanelContentServiceImpl implements PanelContentService {
    private final static Logger logger = LoggerFactory.getLogger(PanelContentServiceImpl.class);

    @Resource
    private PanelProperties panelProperties;

    @Resource
    private PanelContentMapper panelContentMapper;

    @Resource
    private JedisClient jedisClient;

    @Override
    public List<TbPanelContent> getNavList() {

        List<TbPanelContent> list;

        //有缓存则读取
        Optional<String> json = jedisClient.get(panelProperties.getHeader());

        if(json.isPresent()) {
            logger.info("读取了导航栏缓存");
            return JSONObject.parseArray(json.get(), TbPanelContent.class);
        }

        TbPanelContentExample exampleContent = new TbPanelContentExample();
        exampleContent.setOrderByClause("sort_order");
        Criteria criteriaContent = exampleContent.createCriteria();

        //条件查询
        criteriaContent.andPanelIdEqualTo(panelProperties.getId());
        list = panelContentMapper.selectByExample(exampleContent);

        //把结果添加至缓存
        jedisClient.set(panelProperties.getHeader(), JSON.toJSONString(list));
        logger.info("添加了导航栏缓存");

        return list;
    }

    @Override
    public List<TbPanelContent> getHome() {
        return null;
    }
}
