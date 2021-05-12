package com.jachs.redis;

import java.text.SimpleDateFormat;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/***
 * 
 * @author zhanchaohan<br>
 *         save：将数据同步保存到磁盘<br>
 *         bgsave：将数据异步保存到磁盘<br>
 *         lastsave：返回上次成功将数据保存到磁盘的Unix时戳<br>
 *         shundown：将数据同步保存到磁盘，然后关闭服务<br>
 * 本地持久化路径在配置文件中redis.windows.conf，dbfilename属性为文件名，dir为存储的文件路径
 */
public class AddTest {
	Jedis jedis = new RedisConfiger().init();

	/***
	 * 测试保存数据
	 */
	@Test
	public void testSAVEDATE() {
		jedis.configSet("dir", "F:\\down_load\\redis");//设置初始化的配置，修改物理文件存储路径
		jedis.configSet("dbfilename", "data");//设置初始化的配置，修改物理文件存储名称
		System.out.println(jedis.save());
	}
	/***
	 * 关闭服务
	 */
	@Test
	public void testSHOUDOWN() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println(sdf.format(jedis.lastsave()*1000));
//		System.out.println(jedis.shutdown());//关闭服务，关闭之前请确保持久化数据
	}
	/***
	 * 简单键值对存储
	 */
	@Test
	public void test() {
		// 存储数据到列表中
		jedis.lpush("site-list", "Runoob");
		jedis.lpush("site-list", "Google");
		jedis.lpush("site-list", "Taobao");

	}
	/***
	 * 判断索引是否存在
	 */
	@Test
	public void test1() {
		jedis.flushDB();// 清空redis

//		jedis.set("AAA", "CCC");
		Boolean exits = jedis.exists("AAA");

		System.out.println(exits);
	}

	/***
	 * 一次添加多条
	 */
	@Test
	public void test2() {
		System.out.println("一次性新增key201,key202,key203,key204及其对应值："
				+ jedis.mset("key201", "value201", "key202", "value202", "key203", "value203", "key204", "value204"));
	}
	/***
	 * 
	 */
	@Test
	public void test3() {
		
	}
}
