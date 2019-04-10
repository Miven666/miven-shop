package cn.miven.cloud.common.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisCluster;

import java.util.List;
import java.util.Optional;

/**
 * Redis集群操作
 *
 * @author mingzhi.xie
 * @date 2019/4/4
 */
public class JedisClientCluster implements JedisClient {

	private final static Logger logger = LoggerFactory.getLogger(JedisClientCluster.class);

	private JedisCluster jedisCluster;


	public JedisCluster getJedisCluster() {
		return jedisCluster;
	}

	public void setJedisCluster(JedisCluster jedisCluster) {
		this.jedisCluster = jedisCluster;
	}

	@Override
	public Optional<String> set(String key, String value) {
		try {
			return Optional.ofNullable(jedisCluster.set(key, value));
		} catch (Exception e) {
			logger.error("jedisCluster set key='{}', value='{}' error", key, value, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<String> get(String key) {
		try {
			return Optional.ofNullable(jedisCluster.get(key));
		} catch (Exception e) {
			logger.error("jedisCluster get is error with key='{}'", key, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Boolean> exists(String key) {
		try {
			return Optional.ofNullable(jedisCluster.exists(key));
		} catch (Exception e) {
			logger.error("jedisCluster exists is error with key='{}'", key, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Long> expire(String key, int seconds) {
		try {
			return Optional.ofNullable(jedisCluster.expire(key, seconds));
		} catch (Exception e) {
			logger.error("jedisCluster expire is error with key='{}', seconds={}", key, seconds, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Long> ttl(String key) {
		try {
			return Optional.ofNullable(jedisCluster.ttl(key));
		} catch (Exception e) {
			logger.error("jedisCluster ttl is error with key='{}'", key, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Long> incr(String key) {
		try {
			return Optional.ofNullable(jedisCluster.incr(key));
		} catch (Exception e) {
			logger.error("jedisCluster incr is error with key='{}'", key, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Long> hset(String key, String field, String value) {
		try {
			return Optional.ofNullable(jedisCluster.hset(key, field, value));
		} catch (Exception e) {
			logger.error("jedisCluster hset is error with key='{}', field='{}', value='{}'", key, field, value, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<String> hget(String key, String field) {
		try {
			return Optional.ofNullable(jedisCluster.hget(key, field));
		} catch (Exception e) {
			logger.error("jedisCluster hget is error with key='{}', field='{}', value='{}'", key, field, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Long> hdel(String key, String... field) {
		try {
			return Optional.ofNullable(jedisCluster.hdel(key, field));
		} catch (Exception e) {
			logger.error("jedisCluster hdel is error with key='{}', field='{}'", key, field, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Boolean> hexists(String key, String field) {
		try {
			return Optional.ofNullable(jedisCluster.hexists(key, field));
		} catch (Exception e) {
			logger.error("jedisCluster hexists is error with key='{}', field='{}'", key, field, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<List<String>> hvals(String key) {
		try {
			return Optional.ofNullable(jedisCluster.hvals(key));
		} catch (Exception e) {
			logger.error("jedisCluster hvals is error with key='{}'", key, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Long> del(String key) {
		try {
			return Optional.ofNullable(jedisCluster.del(key));
		} catch (Exception e) {
			logger.error("jedisCluster del is error with key='{}'", key, e);
			return Optional.empty();
		}
	}

}
