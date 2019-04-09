package shop.common.util;


import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis连接池工具类
 *
 * @author mingzhi.xie
 * @date 2019/4/9.
 */
public class JedisPoolUtils {

    private final static Logger logger = LoggerFactory.getLogger(JedisPoolUtils.class);

    public static JedisPoolConfig createJedisPoolConfig(@NotNull RedisProperties properties) {
        JedisPoolConfig config = new JedisPoolConfig();
        RedisProperties.Pool pool = properties.getJedis().getPool();
        config.setMaxTotal(pool.getMaxActive());
        config.setMaxWaitMillis(pool.getMaxWait().toMillis());
        config.setMaxIdle(pool.getMaxIdle());
        config.setMinIdle(pool.getMinIdle());
        logger.info("DI JedisPoolConfig Bean success");
        return config;
    }
}
