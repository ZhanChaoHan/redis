package com.jachs.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/***
 * 
 * @author zhanchaohan
 *
 */
public class QueryTest {
	Jedis jedis = new RedisConfiger().init();

	/**
	 * 查询全部key值
	 */
	@Test
	public void testA() {
		// 获取数据并输出
		Set<String> keys = jedis.keys("*");
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
	}
	/***
	 * AddTest.test
	 */
	@Test
	public void test() {
		// 获取存储的数据并输出
		List<String> list = jedis.lrange("site-list", 0, 2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("列表项为: " + list.get(i));
		}
	}
}
