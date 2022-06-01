package com.jachs.redis.add;

import java.util.Set;

import org.junit.After;
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
	private static final String KEY="setKey";
	private static final String KEY_1="setKey02";
	
	
	public void printBe(String k) {
		System.out.println("----------------------");
		Set<String> smembers = jedis.smembers(k);
		smembers.forEach(a->{
			System.out.println(a);
		});
	}
	//添加set数据
	@Test
	public void test1() {
		jedis.sadd(KEY, "zhangsan","lisi","wangmazi","Jachs","some one");
		
		printBe(KEY);
	}
	//删除set数据
	@Test
	public void test2() {
		Long count=jedis.srem(KEY, "wangmazi","zhangsan");
		
		System.out.println("删除行数:"+count);
		
		printBe(KEY);
	}
	//判断set集合是否包含当前value
	@Test
	public void test3() {
		Boolean sismember = jedis.sismember(KEY, "Jachs");
		
		System.out.println(sismember);
		
		printBe(KEY);
	}
	//取数组2中不包含数组1的值
	@Test
	public void test5() {
		jedis.sadd(KEY_1, "aa","bb","cc","Jachs","de");
		
		Set<String> sdiff = jedis.sdiff(KEY,KEY_1);
		
		sdiff.forEach(a->{
			System.out.println(a);
		});
	}
	
}
