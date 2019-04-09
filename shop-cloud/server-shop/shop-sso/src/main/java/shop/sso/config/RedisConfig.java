package shop.sso.config;

import cn.miven.cloud.common.jedis.JedisClientPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;

/**
 * redis 配置
 *
 * @author mingzhi.xie
 * @date 2019/4/9.
 */

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    private final static Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Resource
    private RedisProperties redisProperties;

    @Bean
    public JedisClientPool getJedisClientPool(JedisPool jedisPool) {
        JedisClientPool jedisClientPool = new JedisClientPool();
        jedisClientPool.setJedisPool(jedisPool);
        logger.info("DI JedisClientPool Bean success");
        return jedisClientPool;
    }

    @Bean
    public JedisPool getJedisPool(JedisPoolConfig jedisPoolConfig) {
        logger.info("DI JedisPool Bean success");
        return new JedisPool(jedisPoolConfig,
                redisProperties.getHost(),
                redisProperties.getPort(),
                (int) redisProperties.getTimeout().toMillis(),
                null,
                redisProperties.getDatabase());
    }

    @Bean
    public JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        RedisProperties.Pool pool = redisProperties.getJedis().getPool();
        jedisPoolConfig.setMaxTotal(pool.getMaxActive());
        jedisPoolConfig.setMaxWaitMillis(pool.getMaxWait().toMillis());
        jedisPoolConfig.setMaxIdle(pool.getMaxIdle());
        jedisPoolConfig.setMinIdle(pool.getMinIdle());
        logger.info("DI JedisPoolConfig Bean success");
        return jedisPoolConfig;
    }
}
