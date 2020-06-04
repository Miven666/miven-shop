package shop.content.config;

import shop.common.RedisKey;

/**
 * Shop Content 组件 redis key
 *
 * @author mingzhi.xie
 * @since 2020/5/26 1.0
 */
public interface ShopContentRedisKey extends RedisKey {
    /**
     * 服务名
     */
    String SERVICE_NAME = "shop:content:";
    /**
     * 商品详情
     */
    String GOODS_DETAILS = SERVICE_NAME + "goods:details:";
    /**
     * 商品详情过期时间，单位秒
     */
    int GOODS_DETAILS_EXPIRE = 3600;
}
