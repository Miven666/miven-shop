package cn.miven.cloud.common.jedis;

import java.util.List;

/**
 * Redis操作
 *
 * @author mingzhi.xie
 * @date 2019/4/4
 */
public interface JedisClient {

	/**
	 * 设置给定 key 的值
	 * @param key	key
	 * @param value	value
	 * @return 设置操作成功完成时，才返回OK。
	 */
	String set(String key, String value);

	/**
	 * 获取指定 key 的值
	 * @param key	key
	 * @return 返回key的值，如果key不存在时，返回nil。如果key不是字符串类型，那么返回一个错误。
	 */
	String get(String key);

	/**
	 * 检查给定 key 是否存在
	 * @param key	key
	 * @return 1:存在，0:不存在
	 */
	Boolean exists(String key);

	/**
	 * 设置过期时间，单位秒
	 * @param key		key
	 * @param seconds	seconds
	 * @return 1:成功，0：不存在或者不能为key设置过期时间。
	 */
	Long expire(String key, int seconds);

	/**
	 * 以秒为单位返回 key 的剩余过期时间
	 * @param key	key
	 * @return -2:不存在，-1:存在但没有设置剩余生存时间时，否则key的剩余生存时间。
	 */
	Long ttl(String key);

	/**
	 * key中储存的数字值增一
	 * key不存在，那么key的值会先被初始化为0，然后增一
	 * @param key	key
	 * @return		value
	 */
	Long incr(String key);

	/**
	 * 为哈希表中的字段赋值
	 * @param key	key
	 * @param field	field
	 * @param value	value
	 * @return	1:成功，0:哈希表中域字段已经存在且旧值已被新值覆盖。
	 */
	Long hset(String key, String field, String value);

	/**
	 * 获取哈希表中指定字段的值
	 * @param key	key
	 * @param field	field
	 * @return 返回给定字段的值。如果给定的字段或key不存在时，返回nil 。
	 */
	String hget(String key, String field);

	/**
	 * 删除哈希表 key 中的一个或多个指定字段，不存在的字段将被忽略
	 * @param key	key
	 * @param field	field
	 * @return 被成功删除字段的数量，不包括被忽略的字段。
	 */
	Long hdel(String key, String... field);

	/**
	 * 查看哈希表的指定字段是否存在
	 * @param key	key
	 * @param field	field
	 * @return 1:存在，0: 哈希表不含有给定字段，或key不存在。
	 */
	Boolean hexists(String key, String field);

	/**
	 * 获取哈希表所有字段的值
	 * @param key	key
	 * @return 一个包含哈希表中所有值的表。当key不存在时，返回一个空表。
	 */
	List<String> hvals(String key);

	/**
	 * 删除已存在的键。不存在的 key 会被忽略
	 * @param key key
	 * @return 被删除 key 的数量。
	 */
	Long del(String key);
}
