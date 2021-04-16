package com.jachs.redis;

import redis.clients.jedis.Jedis;

/**
 * 
 * @author zhanchaohan
 *
 */
public class RedisConfiger {
	public Jedis init() {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("localhost");
		// 如果 Redis 服务设置来密码，需要下面这行，没有就不需要
		// jedis.auth("123456");
		System.out.println("连接成功");
		// 查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());

		return jedis;
	}
	
	/***
	 * 刷新数据库,清空全部数据
	 * @param jedis
	 */
	public void flushDB(Jedis jedis) {
		jedis.flushDB();
	}
	/***
	 * 查看某个key的剩余生存时间,单位【秒】.永久生存或者不存在的都返回-1
	 * @param jedis
	 * @param key
	 * @return
	 */
	public Long ttl(Jedis jedis,String key) {
		return  jedis.ttl(key);
	}
}
