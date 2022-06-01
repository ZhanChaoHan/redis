package com.jachs.redis.publish_subscription;

import org.junit.Test;

import com.jachs.redis.RedisConfiger;
import com.jachs.redis.RedisSubscriber;

import redis.clients.jedis.Jedis;

/***
 * 消费者
 * @author zhanchaohan
 *
 */
public class Subscription {
	Jedis jedis = new RedisConfiger().init();
	private static final String PASSAGEWAY="JachsPoll";
	
    
    @Test
    public void init() {
    	//创建订阅者
        RedisSubscriber redisSubscriber = new RedisSubscriber();
        //订阅频道
        jedis.subscribe(redisSubscriber,PASSAGEWAY);
    }
}
