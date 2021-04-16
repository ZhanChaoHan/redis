package com.jachs.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/***
 * 
 * @author zhanchaohan
 *
 */
public class DeleteTest {
	Jedis jedis = new RedisConfiger().init();

	/**
	 * 单条删除
	 */
	@Test
	public void test() {
		String addStr = jedis.set("testDel", "AAAAA");
//		Long del= jedis.del("testDel");

		System.out.println(addStr + ":\t" + jedis.exists("testDel"));
	}
	/***
	 * AddTest.test2
	 * QueryTest.test1
	 */
	@Test
	public void test1() {
		System.out.println("一次性删除key201,key202：" + jedis.del(new String[] { "key201", "key202" }));
	}
}
