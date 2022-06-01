package com.jachs.redis.add;


import org.junit.Test;

import com.jachs.redis.RedisConfiger;

import redis.clients.jedis.Jedis;

/***
	1、String是Redis最基本的数据类型（较常用），一个key对应一个value<br>
	2、String类型是二进制安全的，Redis的String可以包含任何数据<br>
	3、一个Redis中字符串value最多是512M<br>
 *  @author zhanchaohan<br>
 */
public class AddStringTest {
	Jedis jedis = new RedisConfiger().init();

	private static final String KEY="name";
	
	/***
	 * 判断索引是否存在
	 */
	@Test
	public void test1() {
		Boolean exits = jedis.exists(KEY);
		System.out.println(exits);
	}
	
	@Test
	public void te() {
		//设置 redis 字符串数据
       String str= jedis.set(KEY, "Jachs");
       
       System.out.println(str);
       //获取key值
       System.out.println(jedis.get(KEY));
	}
	//根据key取范围值
	@Test
	public void test3() {
		String str=jedis.getrange(KEY, 1, 3);
		
		System.out.println(str);
	}
	//根据key,替换旧值
	@Test
	public void test5() {
		String str=jedis.getSet(KEY, "new Jachs");
		System.out.println("旧值"+str);
		System.out.println("新值"+jedis.get(KEY));
	}
	//获取偏移量，返回键处存储的字符串值中偏移量处的位值
	@Test
	public void test6() {
		boolean boo=jedis.getbit(KEY, 2);
		
		System.out.println(boo);
	}
	
	
	/***
	 * 一次添加多条
	 */
	@Test
	public void test2() {
		System.out.println("一次性新增key201,key202,key203,key204及其对应值："
				+ jedis.mset("key201", "value201", "key202", "value202", "key203", "value203", "key204", "value204"));
	}
}
