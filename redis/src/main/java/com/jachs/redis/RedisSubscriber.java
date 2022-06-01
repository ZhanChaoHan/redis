package com.jachs.redis;

import redis.clients.jedis.JedisPubSub;

/***
 * 
 * @author zhanchaohan
 *
 */
public class RedisSubscriber extends JedisPubSub{
	
	@Override
	public void onMessage(String channel, String message) {
		System.out.println("通道:"+channel+"\t\t收到消息:"+message);
	}
}
