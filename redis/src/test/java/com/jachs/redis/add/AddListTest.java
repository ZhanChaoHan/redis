package com.jachs.redis.add;

import java.util.List;

import org.junit.Test;

import com.jachs.redis.RedisConfiger;

import redis.clients.jedis.Jedis;

/***
	Redis List的实现为一个双向链表，即可以支持反向查找和遍历，更方便操作，不过带来了部分额外的内存开销，Redis内部的很多实现，包括发送缓冲队列等也都是用这个数据结构。List类型主要用于队列和栈，先进先出，后进先出等。
  	@author zhanchaohan
 *
 */
public class AddListTest {
	Jedis jedis = new RedisConfiger().init();
	
	@Test
	public void test1() {
		String key="test-list";
		//存储数据到列表中
        jedis.lpush(key, "Runoob");
        jedis.lpush(key, "Google");
        jedis.lpush(key, "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange(key, 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
	}
	
	
}
