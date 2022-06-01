package com.jachs.redis;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/***
 * 持久化
 * @author zhanchaohan
 *
 */
public class SaveTest {
	Jedis jedis = new RedisConfiger().init();
	
	//设置redis配置如果不设置默认取配置文件配置信息
	@Before
	public void init() {
		jedis.configSet("dir", "E:\\a");//设置初始化的配置，修改物理文件存储路径
		jedis.configSet("dbfilename", "data");//设置初始化的配置，修改物理文件存储名称
	}
	
	@Test
	public void test1() {
		String str=jedis.save();//将数据同步保存到磁盘
		
		System.out.println(str);
	}
	
	@Test
	public void test2() {
		String str=jedis.bgsave();//将数据异步保存到磁盘
		
		System.out.println(str);
	}
	
	@Test
	public void test3() {
		String str=jedis.shutdown();//将数据同步保存到磁盘，然后关闭服务
		
		System.out.println(str);
	}
}
