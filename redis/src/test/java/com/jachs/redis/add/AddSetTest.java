package com.jachs.redis.add;

import org.junit.Test;

import com.jachs.redis.RedisConfiger;

import redis.clients.jedis.Jedis;

/***
	Redis 的 Set 是 String 类型的无序集合。集合成员是唯一的，这就意味着集合中不能出现重复的数据。</br>
	集合对象的编码可以是 intset 或者 hashtable。</br>
	Redis 中集合是通过哈希表实现的，所以添加，删除，查找的复杂度都是 O(1)。</br>
	集合中最大的成员数为 232 - 1 (4294967295, 每个集合可存储40多亿个成员)。 </br>
    @author zhanchaohan
 *
 */
public class AddSetTest {
	Jedis jedis = new RedisConfiger().init();
	
	@Test
	public void test1() {
		
	}
}
