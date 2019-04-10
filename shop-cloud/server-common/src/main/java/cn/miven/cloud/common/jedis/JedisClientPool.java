package cn.miven.cloud.common.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * Redis连接池操作
 *
 * @author mingzhi.xie
 * @date 2019/4/4
 */
public class JedisClientPool implements JedisClient {

	private final static Logger logger = LoggerFactory.getLogger(JedisClientPool.class);

	private JedisPool jedisPool;

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	@Override
	public String set(String key, String value) {
		String result;
		try (Jedis jedis = jedisPool.getResource()) {
			result = jedis.set(key, value);
		} catch (Exception e) {
			logger.error("jedis set key='{}', value='{}' error", key, value, e);
			return null;
		}
		return result;
	}

	@Override
	public String get(String key) {
		String result;
		try (Jedis jedis = jedisPool.getResource()) {
			result = jedis.get(key);
		} catch (Exception e) {
			logger.error("jedis get is error with key='{}'", key, e);
			return null;
		}
		return result;
	}

	@Override
	public Boolean exists(String key) {
		Boolean result;
		try (Jedis jedis = jedisPool.getResource()) {
			result = jedis.exists(key);
		} catch (Exception e) {
			logger.error("jedis exists is error with key='{}'", key, e);
			return null;
		}
		return result;
	}

	@Override
	public Long expire(String key, int seconds) {
		Long result;
		try (Jedis jedis = jedisPool.getResource()) {
			result = jedis.expire(key, seconds);
		} catch (Exception e) {
			logger.error("jedis expire is error with key='{}', seconds={}", key, seconds, e);
			return null;
		}
		return result;
	}

	@Override
	public Long ttl(String key) {
		Long result;
		try (Jedis jedis = jedisPool.getResource()) {
			result = jedis.ttl(key);
		} catch (Exception e) {
			logger.error("jedis ttl is error with key='{}'", key, e);
			return null;
		}
		return result;
	}

	@Override
	public Long incr(String key) {
		Long result;
		try (Jedis jedis = jedisPool.getResource()) {
			result = jedis.incr(key);
		} catch (Exception e) {
			logger.error("jedis incr is error with key='{}'", key, e);
			return null;
		}
		return result;
	}

	@Override
	public Long hset(String key, String field, String value) {
		Long result;
		try (Jedis jedis = jedisPool.getResource()) {
			result = jedis.hset(key, field, value);
		} catch (Exception e) {
			logger.error("jedis hset is error with key='{}', field='{}', value='{}'", key, field, value, e);
			return null;
		}
		return result;
	}

	@Override
	public String hget(String key, String field) {
		String result;
		try (Jedis jedis = jedisPool.getResource()) {
			result = jedis.hget(key, field);
		} catch (Exception e) {
			logger.error("jedis hget is error with key='{}', field='{}', value='{}'", key, field, e);
			return null;
		}
		return result;
	}

	@Override
	public Long hdel(String key, String... field) {
		Long result;
		try (Jedis jedis = jedisPool.getResource()) {
			result = jedis.hdel(key, field);
		} catch (Exception e) {
			logger.error("jedis hdel is error with key='{}', field='{}'", key, field, e);
			return null;
		}
		return result;
	}

	@Override
	public Boolean hexists(String key, String field) {
		Boolean result;
		try (Jedis jedis = jedisPool.getResource()) {
			result = jedis.hexists(key, field);
		} catch (Exception e) {
			logger.error("jedis hexists is error with key='{}', field='{}'", key, field, e);
			return null;
		}
		return result;
	}

	@Override
	public List<String> hvals(String key) {
		List<String> result;
		try (Jedis jedis = jedisPool.getResource()) {
			result = jedis.hvals(key);
		} catch (Exception e) {
			logger.error("jedis hvals is error with key='{}'", key, e);
			return null;
		}
		return result;
	}

	@Override
	public Long del(String key) {
		Long result;
		try (Jedis jedis = jedisPool.getResource()) {
			result = jedis.del(key);
		} catch (Exception e) {
			logger.error("jedis del is error with key='{}'", key, e);
			return null;
		}
		return result;
	}

}
