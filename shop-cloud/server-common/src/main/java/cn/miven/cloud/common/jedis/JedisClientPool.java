package cn.miven.cloud.common.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Optional;

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
	public Optional<String> set(String key, String value) {
		try (Jedis jedis = jedisPool.getResource()) {
            return Optional.of(jedis.set(key, value));
		} catch (Exception e) {
			logger.error("jedis set key='{}', value='{}' error", key, value, e);
            return Optional.empty();
		}
	}

	@Override
	public Optional<String> get(String key) {
		try (Jedis jedis = jedisPool.getResource()) {
		    return Optional.of(jedis.get(key));
		} catch (Exception e) {
			logger.error("jedis get is error with key='{}'", key, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Boolean> exists(String key) {
		try (Jedis jedis = jedisPool.getResource()) {
			return Optional.of(jedis.exists(key));
		} catch (Exception e) {
			logger.error("jedis exists is error with key='{}'", key, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Long> expire(String key, int seconds) {
		try (Jedis jedis = jedisPool.getResource()) {
			return Optional.of(jedis.expire(key, seconds));
		} catch (Exception e) {
			logger.error("jedis expire is error with key='{}', seconds={}", key, seconds, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Long> ttl(String key) {
		try (Jedis jedis = jedisPool.getResource()) {
			return Optional.of(jedis.ttl(key));
		} catch (Exception e) {
			logger.error("jedis ttl is error with key='{}'", key, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Long> incr(String key) {
		try (Jedis jedis = jedisPool.getResource()) {
			return Optional.of(jedis.incr(key));
		} catch (Exception e) {
			logger.error("jedis incr is error with key='{}'", key, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Long> hset(String key, String field, String value) {
		try (Jedis jedis = jedisPool.getResource()) {
			return Optional.of(jedis.hset(key, field, value));
		} catch (Exception e) {
			logger.error("jedis hset is error with key='{}', field='{}', value='{}'", key, field, value, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<String> hget(String key, String field) {
		try (Jedis jedis = jedisPool.getResource()) {
			return Optional.of(jedis.hget(key, field));
		} catch (Exception e) {
			logger.error("jedis hget is error with key='{}', field='{}', value='{}'", key, field, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Long> hdel(String key, String... field) {
		try (Jedis jedis = jedisPool.getResource()) {
			return Optional.of(jedis.hdel(key, field));
		} catch (Exception e) {
			logger.error("jedis hdel is error with key='{}', field='{}'", key, field, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Boolean> hexists(String key, String field) {
		try (Jedis jedis = jedisPool.getResource()) {
			return Optional.of(jedis.hexists(key, field));
		} catch (Exception e) {
			logger.error("jedis hexists is error with key='{}', field='{}'", key, field, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<List<String>> hvals(String key) {
		try (Jedis jedis = jedisPool.getResource()) {
			return Optional.of(jedis.hvals(key));
		} catch (Exception e) {
			logger.error("jedis hvals is error with key='{}'", key, e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<Long> del(String key) {
		try (Jedis jedis = jedisPool.getResource()) {
			return Optional.of(jedis.del(key));
		} catch (Exception e) {
			logger.error("jedis del is error with key='{}'", key, e);
			return Optional.empty();
		}
	}

}
