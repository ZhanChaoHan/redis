package com.jachs.redis.publish_subscription;

import java.util.Scanner;

import org.junit.Test;

import com.jachs.redis.RedisConfiger;

import redis.clients.jedis.Jedis;

/***
 * 生产者
 * @author zhanchaohan
 *
 */
public class PublishDemo {
	Jedis jedis = new RedisConfiger().init();
	private static final String PASSAGEWAY="JachsPoll";
	
	@Test
	public void test1() {
		Scanner scann=new Scanner(System.in);
		
		while(true) {
			String str=scann.next();
			//发布消息
	        jedis.publish(PASSAGEWAY, str);
	        System.out.println("消息发送完毕......\t"+str);
		}
	}
}
