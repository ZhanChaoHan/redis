package com.jachs.redis.add;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.jachs.redis.RedisConfiger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.ZAddParams;

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
	private static final String KEY="z_setKey";
	private static final String KEY_1="z_setKey02";
	
	//添加双精度数据
	@Test
	public void test1() {
		jedis.zadd(KEY,2.36,"jack");
		jedis.zadd(KEY,1.36,"jame");
		jedis.zadd(KEY,5.6,"pens");
		jedis.zadd(KEY,3.6,"大头");
		jedis.zadd(KEY,0.6,"百度");
		jedis.zadd(KEY,8.6,"cji");
	}
	//取单值
	@Test
	public void test6() {
		System.out.println(jedis.zscore(KEY, "jack"));
	}
	
	//取范围数据
	@Test
	public void test2() {
		Long start=1L;
		Long end=5L;
		
		Set<String> set=jedis.zrange(KEY,start,end);
		
		set.forEach(a->{
			System.out.println(a);
		});
	}
	//取范围数个数
	@Test
	public void test5() {
		Long start=1L;
		Long end=5L;
		
		Long count=jedis.zcount(KEY, start, end);
		
		System.out.println(count);
	}
	
	//删除
	@Test
	public void test3() {
		jedis.zrem(KEY, "pens","jame");
		
		Long start=1L;
		Long end=10L;
		
		Set<String> set=jedis.zrange(KEY,start,end);
		
		set.forEach(a->{
			System.out.println(a);
		});
	}
}
