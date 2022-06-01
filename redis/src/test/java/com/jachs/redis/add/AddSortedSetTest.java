package com.jachs.redis.add;

import org.junit.Test;

import com.jachs.redis.RedisConfiger;

import redis.clients.jedis.Jedis;

/***
    Redis 有序集合和集合一样也是 string 类型元素的集合,且不允许重复的成员。</br>
	不同的是每个元素都会关联一个 double 类型的分数。redis 正是通过分数来为集合中的成员进行从小到大的排序。</br>
	有序集合的成员是唯一的,但分数(score)却可以重复。</br>
	集合是通过哈希表实现的，所以添加，删除，查找的复杂度都是 O(1)。 集合中最大的成员数为 232 - 1 (4294967295, 每个集合可存储40多亿个成员)。 </br>
    @author zhanchaohan
 *
 */
public class AddSortedSetTest {
	Jedis jedis = new RedisConfiger().init();
	
	@Test
	public void test1() {
		
	}
}
